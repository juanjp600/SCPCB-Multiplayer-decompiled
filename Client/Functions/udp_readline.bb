Function udp_readline$()
    Local local0%
    Local local1$
    Repeat
        local0 = udp_readbyte()
        If (((local0 = $00) Or (local0 = $0A)) <> 0) Then
            Exit
        EndIf
        If (local0 <> $0D) Then
            local1 = (local1 + chr(local0))
        EndIf
    Forever
    Return local1
    Return ""
End Function
