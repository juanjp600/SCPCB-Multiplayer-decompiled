Function setplayervoicemute%(arg0.mp_player, arg1%)
    If (arg1 = $FFFFFFFF) Then
        arg0\Field36\Field3 = (arg0\Field36\Field3 = $00)
        Return $00
    EndIf
    arg0\Field36\Field3 = arg1
    Return $00
End Function
