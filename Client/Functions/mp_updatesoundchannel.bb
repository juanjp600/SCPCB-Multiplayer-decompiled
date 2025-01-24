Function mp_updatesoundchannel%(arg0.mp_soundchannel)
    Local local0#
    local0 = arg0\Field3
    If (ue_players[arg0\Field4] <> Null) Then
        positionentity(arg0\Field5, ue_players[arg0\Field4]\Field7, ue_players[arg0\Field4]\Field8, ue_players[arg0\Field4]\Field9, $00)
        If (arg0\Field7 <> 0) Then
            local0 = (ue_players[arg0\Field4]\Field24 * local0)
        EndIf
    EndIf
    updatesoundorigin(arg0\Field1, camera, arg0\Field5, arg0\Field2, local0, arg0\Field6, $01)
    If (channelplaying(arg0\Field1) = $00) Then
        mp_flushsoundchannel(arg0)
    EndIf
    Return $00
End Function
