Function flushplayermodel%(arg0.mp_player)
    Local local0%
    If (arg0\Field35\Field0 = $00) Then
        Return $00
    EndIf
    For local0 = $00 To $09 Step $01
        removeplayerattach(arg0\Field35, local0, $01)
    Next
    freeentity(arg0\Field35\Field0)
    arg0\Field35\Field0 = $00
    hideentity(arg0\Field18)
    arg0\Field35\Field0 = $00
    arg0\Field35\Field2 = $00
    arg0\Field35\Field3 = $00
    Return $01
    Return $00
End Function
