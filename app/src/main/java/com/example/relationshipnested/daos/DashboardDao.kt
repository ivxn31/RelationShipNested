package com.example.relationshipnested.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.relationshipnested.entities.*
import com.example.relationshipnested.enums.Disposition
import com.example.relationshipnested.models.*

@Dao
abstract class DashboardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveDashboard(dashboard:DashboardEntity):Long

    @Insert
    abstract suspend fun saveTheme(theme: ThemeEntity):Long

    @Insert
    abstract suspend fun saveSection(theme: SectionEntity):Long

    @Insert
    abstract suspend fun saveWidgetGroup(widgetsGroup: WidgetsGroupEntity):Long

    @Insert
    abstract suspend fun saveAlertsWidget(alertsWidget: List<AlertEntity>)

    @Insert
    abstract suspend fun saveBannersWidget(bannersWidget: List<BannerEntity>)

    @Insert
    abstract suspend fun saveBubblesWidget(bubblesWidget: List<BubbleEntity>)

    @Insert
    abstract suspend fun saveWideCardWidget(wideCardWidget: WideCardEntity):Long

    @Insert
    abstract suspend fun saveWideCardWidgetFooter(wideCardFooterWidget: WideCardFooterEntity)

    suspend fun  saveDashboardInformation(dashboard: Dashboard){
        val dashboardTable = DashboardEntity(dashboard.version.toString(),dashboard.playerEnabled)
        val dashboardId = saveDashboard(dashboardTable)

        dashboard.sections?.also { sections ->

        }
    }

    private fun convertSectionToSectionEntity(
        dashboardTableID:Long,
        themeId:Long,
        section: Section): SectionEntity {
        return SectionEntity(
            dashboardId = dashboardTableID,
            themeId = themeId,
            title = section.title,
            order = section.order,
            icon = section.icon,
            enabled = section.enabled
        )
    }

    private fun convertThemeToThemeEntity(theme: Theme):ThemeEntity{
        return ThemeEntity(
            primaryBackgroundColor = theme.primaryBackgroundColor,
            secondaryBackgroundColor = theme.secondaryBackgroundColor,
            primaryIconColor = theme.primaryIconColor,
            secondaryIconColor = theme.secondaryIconColor,
            primaryFontColor = theme.primaryFontColor,
            secondaryFontColor = theme.secondaryFontColor,
            selectedBackgroundColor = theme.selectedBackgroundColor,
        )
    }

    private suspend fun addSection(
        section: Section,
        SectionEntity: SectionEntity){
        val sectionId = saveSection(SectionEntity)
        section.widgets.forEach { widgetGroupJson ->
            val widgetsGroupEntity = convertWidgetToWidgetGroupEntity(sectionId,widgetGroupJson)
            val widgetGroupId = saveWidgetGroup(widgetsGroupEntity)
            addBubblesWidget(widgetGroupId,widgetGroupJson.bubbles)
            addAlertsWidget(widgetGroupId,widgetGroupJson.alerts)
            addBannersWidget(widgetGroupId,widgetGroupJson.banners)
            addWideCardWidget(widgetGroupId,widgetGroupJson.wideCards)
        }
    }

    private fun convertWidgetToWidgetGroupEntity(sectionId:Long, widgetGroup: WidgetGroup):WidgetsGroupEntity{
        return WidgetsGroupEntity(
            sectionId = sectionId,
            order = widgetGroup.order,
            title = widgetGroup.title,
            disposition = convertDispositionString(widgetGroup.disposition),
            columns = widgetGroup.columns,
            rows = widgetGroup.rows
        )
    }

    private fun convertDispositionString(disposition:Disposition) =
        when(disposition){
            Disposition.V -> "VERTICAL"
            Disposition.H -> "HORIZONTAL"
            Disposition.G -> "GRID"
        }

    private suspend fun addBubblesWidget(widgetGroupId:Long, bubbles: List<Bubble>){
        val bubblesEntities = bubbles.map { bubble ->
            val themeId = bubble.theme?.run {
                saveTheme(convertThemeToThemeEntity(this))
            } ?: 0L
            convertBubbleToBubbleEntity(widgetGroupId,themeId,bubble)
        }
        saveBubblesWidget(bubblesEntities)
    }

    private fun convertBubbleToBubbleEntity(
        widgetGroupId:Long,
        themeId:Long,
        bubble: Bubble):BubbleEntity{
        return BubbleEntity(
            widgetGroupId = widgetGroupId,
            themeId = themeId,
            title = bubble.title,
            order = bubble.order,
            icon = bubble.icon
        )
    }

    private suspend fun addAlertsWidget(widgetGroupId:Long, alerts:List<Alert>){
        val alertsEntities = alerts.map { alert ->
            convertAlertToAlertEntity(widgetGroupId,alert)
        }
        saveAlertsWidget(alertsEntities)
    }

    private fun convertAlertToAlertEntity(
        widgetGroupId:Long,
        alert: Alert):AlertEntity{
        return AlertEntity(
            widgetGroupId = widgetGroupId,
            icon = alert.icon,
            title = alert.title,
            subTitle = alert.subTitle
        )
    }

    private suspend fun addBannersWidget(widgetGroupId:Long, banners:List<Banner>){
        val bannersEntities = banners.map { banner ->
            convertBannerToBannerEntity(widgetGroupId,banner)
        }
        saveBannersWidget(bannersEntities)
    }

    private fun convertBannerToBannerEntity(
        widgetGroupId:Long,
        banner: Banner):BannerEntity{
        return BannerEntity(
            widgetGroupId = widgetGroupId,
            imageUrl = banner.imageUrl,
            visible = banner.visible,
            //campaignId = banner.campaignId,
        )
    }

    private suspend fun addWideCardWidget(widgetGroupId:Long,wideCardsJson:List<WideCard>){
        wideCardsJson.forEach { wideCard ->
            val wideCardEntity = convertWideCardToWideCardWidgetEntity(widgetGroupId,wideCard)
            val wideCardId = saveWideCardWidget(wideCardEntity)
            addWideCardFooterWidget(wideCardId,wideCard.footer)
        }
    }

    private fun convertWideCardToWideCardWidgetEntity(
        widgetGroupId:Long,
        wideCard:WideCard):WideCardEntity{
        return WideCardEntity(
            widgetGroupId = widgetGroupId,
            title = wideCard.title,
            subTitle = wideCard.subTitle,
            imageUrl = wideCard.imageUrl,
            imageAsset = wideCard.imageAsset
        )
    }

    private suspend fun addWideCardFooterWidget(wideCardId:Long,wideCardFooter:WideCardFooter){
        val wideCardFooterEntity = convertFooterWideCardToWideCardWidgetFooterEntity(wideCardId,wideCardFooter)
        saveWideCardWidgetFooter(wideCardFooterEntity)
    }

    private fun convertFooterWideCardToWideCardWidgetFooterEntity(
        wideCardId:Long,
        wideCardFooter:WideCardFooter):WideCardFooterEntity{
        return WideCardFooterEntity(
            wideCardId = wideCardId,
            icon = wideCardFooter.icon,
            text = wideCardFooter.text,
        )
    }
}