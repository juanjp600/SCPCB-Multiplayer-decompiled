Function drawquickloading%()
    Local local0#
    Local local1%
    Local local2%
    If (quickloadpercent > $FFFFFFFF) Then
        local0 = menuscale
        local1 = graphicwidth
        local2 = graphicheight
        midhandle(quickloadicon)
        drawimage(quickloadicon, (Int ((Float local1) - (90.0 * local0))), (Int ((Float local2) - (150.0 * local0))), $00)
        setcolorex($FF, $FF, $FF)
        setfontex(fonts[$00]\Field0)
        text((Int ((Float local1) - (100.0 * local0))), (Int ((Float local2) - (90.0 * local0))), (("LOADING: " + (Str quickloadpercent)) + "%"), $01, $00)
        If (quickloadpercent > $63) Then
            If (70.0 > quickloadpercent_displaytimer) Then
                quickloadpercent_displaytimer = min((quickloadpercent_displaytimer + fpsfactor), 70.0)
            Else
                quickloadpercent = $FFFFFFFF
            EndIf
        EndIf
        quickloadevents()
    Else
        quickloadpercent = $FFFFFFFF
        quickloadpercent_displaytimer = 0.0
        quickload_currevent = Null
    EndIf
    Return $00
End Function
