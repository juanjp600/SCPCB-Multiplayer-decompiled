Function update3dsounds%()
    Local local0.snd3d
    For local0 = Each snd3d
        If (local0\Field0 = $00) Then
            If (local0\Field5 <> $00) Then
                updatesoundorigin(local0\Field2, camera, local0\Field5, local0\Field3, local0\Field4)
            EndIf
            If (channelplaying(local0\Field2) = $00) Then
                stopchannel(local0\Field2)
                If (local0\Field6 <> $00) Then
                    freeentity(local0\Field5)
                EndIf
                Delete local0
            EndIf
        Else
            If (local0\Field5 <> $00) Then
                updatesoundfmod(local0\Field2, camera, local0\Field5, local0\Field3, local0\Field4)
            EndIf
            If (fsound_isplaying(local0\Field2) = $00) Then
                fsound_stopsound(local0\Field2)
                fsound_stream_close(local0\Field1)
                Delete local0
            EndIf
        EndIf
    Next
    Return $00
End Function
