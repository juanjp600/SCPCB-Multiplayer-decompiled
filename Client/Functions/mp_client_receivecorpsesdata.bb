Function mp_client_receivecorpsesdata%()
    Local local0%
    Local local1.mp_playercorpse
    Repeat
        local0 = mp_readbyte()
        If (((local0 = $00) Lor (local0 > $C8)) <> 0) Then
            Exit
        EndIf
        mp_client_receivecorpse(local0, $00)
    Forever
    For local1 = Each mp_playercorpse
        If (((local1\Field13 = $00) And (local1\Field11 = $00)) <> 0) Then
            mp_flushcorpse(local1)
        Else
            local1\Field13 = $00
        EndIf
    Next
    Return $00
End Function
