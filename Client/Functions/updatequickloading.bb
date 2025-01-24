Function updatequickloading%()
    If (quickloadpercent > $FFFFFFFF) Then
        If (quickloadpercent > $63) Then
            If (70.0 > quickloadpercent_displaytimer) Then
                quickloadpercent_displaytimer = min((fps\Field7[$00] + quickloadpercent_displaytimer), 70.0)
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
