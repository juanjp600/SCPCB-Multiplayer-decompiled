Function initializeplayer.mp_player(arg0%, arg1%, arg2%)
    Local local0.mp_player
    If (ue_players[arg0] <> Null) Then
        Return Null
    EndIf
    local0 = (New mp_player)
    local0\Field5 = arg0
    local0\Field0 = arg1
    local0\Field1 = arg2
    local0\Field35 = (New mp_playermodel)
    If (mp_ishoster() <> 0) Then
        local0\Field4 = (New mp_playerserverlogic)
    EndIf
    createplayervoice(local0)
    initializeplayerpivot(local0)
    initializeplayertags(local0)
    initializeplayerattaches(local0)
    local0\Field17 = $00
    ue_players[arg0] = local0
    Return ue_players[arg0]
    Return Null
End Function
