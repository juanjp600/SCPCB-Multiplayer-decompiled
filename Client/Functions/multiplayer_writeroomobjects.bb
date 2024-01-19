Function multiplayer_writeroomobjects%()
    Local local0.rooms
    Local local1%
    For local0 = Each rooms
        If (isablockedroom(local0) = $00) Then
            For local1 = $00 To $1D Step $01
                If (local0\Field25[local1] <> $00) Then
                    multiplayer_writeroomobject(local0, local1)
                EndIf
            Next
        EndIf
    Next
    udp_writebyte($00)
    Return $00
End Function
