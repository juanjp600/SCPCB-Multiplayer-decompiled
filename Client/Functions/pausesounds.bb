Function pausesounds%()
    Local local0.events
    Local local1.npcs
    Local local2.doors
    Local local3.devilemitters
    For local0 = Each events
        If (local0\Field5 <> $00) Then
            If (local0\Field9 = $00) Then
                If (channelplaying(local0\Field5) <> 0) Then
                    pausechannel(local0\Field5)
                EndIf
            Else
                setstreampaused_strict(local0\Field5, $01)
            EndIf
        EndIf
        If (local0\Field6 <> $00) Then
            If (local0\Field10 = $00) Then
                If (channelplaying(local0\Field6) <> 0) Then
                    pausechannel(local0\Field6)
                EndIf
            Else
                setstreampaused_strict(local0\Field6, $01)
            EndIf
        EndIf
    Next
    For local1 = Each npcs
        If (local1\Field17 <> $00) Then
            If (local1\Field70 = $00) Then
                If (channelplaying(local1\Field17) <> 0) Then
                    pausechannel(local1\Field17)
                EndIf
            ElseIf (local1\Field70 = $01) Then
                setstreampaused_strict(local1\Field17, $01)
            EndIf
        EndIf
        If (local1\Field20 <> $00) Then
            If (local1\Field71 = $00) Then
                If (channelplaying(local1\Field20) <> 0) Then
                    pausechannel(local1\Field20)
                EndIf
            ElseIf (local1\Field71 = $01) Then
                setstreampaused_strict(local1\Field20, $01)
            EndIf
        EndIf
    Next
    For local2 = Each doors
        If (local2\Field16 <> $00) Then
            If (channelplaying(local2\Field16) <> 0) Then
                pausechannel(local2\Field16)
            EndIf
        EndIf
    Next
    For local3 = Each devilemitters
        If (local3\Field8 <> $00) Then
            If (channelplaying(local3\Field8) <> 0) Then
                pausechannel(local3\Field8)
            EndIf
        EndIf
    Next
    If (ambientsfxchn <> $00) Then
        If (channelplaying(ambientsfxchn) <> 0) Then
            pausechannel(ambientsfxchn)
        EndIf
    EndIf
    If (breathchn <> $00) Then
        If (channelplaying(breathchn) <> 0) Then
            pausechannel(breathchn)
        EndIf
    EndIf
    If (coughchn <> $00) Then
        If (channelplaying(coughchn) <> 0) Then
            pausechannel(coughchn)
        EndIf
    EndIf
    If (vomitchn <> $00) Then
        If (channelplaying(vomitchn) <> 0) Then
            pausechannel(vomitchn)
        EndIf
    EndIf
    If (intercomstreamchn <> $00) Then
        setstreampaused_strict(intercomstreamchn, $01)
    EndIf
    Return $00
End Function
