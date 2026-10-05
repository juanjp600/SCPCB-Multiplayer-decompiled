Function shoulddrawpointer%()
    If (invopen <> 0) Then
        Return $01
    EndIf
    If (tab_menu_state > $01) Then
        Return $01
    EndIf
    If (menuopen <> 0) Then
        Return $01
    EndIf
    If (consoleopen <> 0) Then
        Return $01
    EndIf
    If (0.0 > endingtimer) Then
        Return $01
    EndIf
    If (selecteddoor <> Null) Then
        Return $01
    EndIf
    If (otheropen <> Null) Then
        Return $01
    EndIf
    If (networkserver <> Null) Then
        If (networkserver\Field19 <> 0) Then
            Return $01
        EndIf
    EndIf
    Return $00
    Return $00
End Function
