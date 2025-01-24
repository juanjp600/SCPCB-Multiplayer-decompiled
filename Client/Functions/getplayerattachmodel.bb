Function getplayerattachmodel%(arg0.mp_player, arg1%)
    Local local0.mp_playerattach
    local0 = arg0\Field35\Field21[arg1]
    If (local0\Field3 <> Null) Then
        Return local0\Field3\Field0
    EndIf
    Return $00
    Return $00
End Function
