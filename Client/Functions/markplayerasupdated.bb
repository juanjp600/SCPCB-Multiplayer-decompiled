Function markplayerasupdated%(arg0.mp_player)
    If (mp_ishoster() = $00) Then
        Return $00
    EndIf
    arg0\Field17 = (arg0\Field17 + $01)
    If (arg0\Field17 >= $100) Then
        arg0\Field17 = $01
    EndIf
    Return $00
End Function
