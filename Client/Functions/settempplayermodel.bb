Function settempplayermodel%(arg0.mp_player, arg1%)
    Local local0%
    Local local1%
    If (((mp_ishoster() = $00) Lor (arg0\Field35\Field10 <> $00)) <> 0) Then
        Return $00
    EndIf
    local0 = arg0\Field35\Field17
    local1 = arg0\Field35\Field18
    setplayermodel(arg0, arg1, $00)
    arg0\Field35\Field10 = local0
    arg0\Field35\Field11 = local1
    Return $00
End Function
