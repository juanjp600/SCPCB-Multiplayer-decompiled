Function updatemisc%()
    If (((mousehit1 And (tab_menu_state < $02)) And (tab_menu_state > $00)) <> 0) Then
        tab_menu_state = $02
        mousehit1 = $00
    EndIf
    shouldentitiesfall = $01
    updatecheckpoint1 = $00
    updatecheckpoint2 = $00
    playersoundvolume = curvevalue(0.0, playersoundvolume, ((Float (networkserver\Field15 * $1E)) + 5.0))
    cansave = $01
    If ((((playerroom\Field7\Field11 = "dimension1499") And (quickloadpercent > $00)) And (quickloadpercent < $64)) <> 0) Then
        shouldentitiesfall = $00
    EndIf
    infacility = checkforplayerinfacility()
    Return $00
End Function
