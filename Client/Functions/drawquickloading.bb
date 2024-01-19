Function drawquickloading%()
    If (quickloadpercent > $FFFFFFFF) Then
        midhandle(quickloadicon)
        drawimage(quickloadicon, (graphicwidth - $5A), (graphicheight - $96), $00)
        color($FF, $FF, $FF)
        aasetfont(font1)
        aatext((graphicwidth - $64), (graphicheight - $5A), (("LOADING: " + (Str quickloadpercent)) + "%"), $01, $00, 1.0)
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
