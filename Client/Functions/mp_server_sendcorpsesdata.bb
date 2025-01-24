Function mp_server_sendcorpsesdata%()
    Local local0.mp_player
    Local local1.mp_playercorpse
    For local0 = Each mp_player
        If (local0\Field5 > $01) Then
            mp_writebyte($06)
            mp_writebyte($05)
            For local1 = Each mp_playercorpse
                If (((400.0 > entitydistancesquared(local1\Field2, local0\Field18)) And (local1\Field11 = $00)) <> 0) Then
                    mp_server_fillcorpsedata(local1)
                EndIf
            Next
            mp_writebyte($00)
            mp_send(local0\Field0, local0\Field1)
        EndIf
    Next
    Return $00
End Function
