Function mp_server_explorecorpse%(arg0.mp_player, arg1%)
    Local local0.mp_playercorpse
    If (arg0\Field4\Field4 <> 0) Then
        Return $00
    EndIf
    If (determinepacketflooding(arg0, $03, $01, $7D0) <> 0) Then
        Return $00
    EndIf
    If (arg1 < $C8) Then
        local0 = mp_corpses[arg1]
        If (((local0 <> Null) And (2.25 > entitydistancesquared(local0\Field1, arg0\Field18))) <> 0) Then
            mp_explorecorpse(local0)
        EndIf
    EndIf
    Return $00
End Function
