Function killsounds%()
    Local local0%
    Local local1.events
    Local local2.npcs
    Local local3.doors
    Local local4.devilemitters
    Local local5.sound
    For local0 = $00 To $09 Step $01
        If (tempsounds[local0] <> $00) Then
            freesound_strict(tempsounds[local0])
            tempsounds[local0] = $00
        EndIf
    Next
    For local1 = Each events
        If (local1\Field5 <> $00) Then
            If (local1\Field9 = $00) Then
                If (channelplaying(local1\Field5) <> 0) Then
                    stopchannel(local1\Field5)
                EndIf
            Else
                stopstream_strict(local1\Field5)
            EndIf
        EndIf
        If (local1\Field6 <> $00) Then
            If (local1\Field10 = $00) Then
                If (channelplaying(local1\Field6) <> 0) Then
                    stopchannel(local1\Field6)
                EndIf
            Else
                stopstream_strict(local1\Field6)
            EndIf
        EndIf
    Next
    For local2 = Each npcs
        If (local2\Field17 <> $00) Then
            If (local2\Field70 = $00) Then
                If (channelplaying(local2\Field17) <> 0) Then
                    stopchannel(local2\Field17)
                EndIf
            Else
                stopstream_strict(local2\Field17)
            EndIf
        EndIf
        If (local2\Field20 <> $00) Then
            If (local2\Field71 = $00) Then
                If (channelplaying(local2\Field20) <> 0) Then
                    stopchannel(local2\Field20)
                EndIf
            Else
                stopstream_strict(local2\Field20)
            EndIf
        EndIf
    Next
    For local3 = Each doors
        If (local3\Field16 <> $00) Then
            If (channelplaying(local3\Field16) <> 0) Then
                stopchannel(local3\Field16)
            EndIf
        EndIf
    Next
    For local4 = Each devilemitters
        If (local4\Field8 <> $00) Then
            If (channelplaying(local4\Field8) <> 0) Then
                stopchannel(local4\Field8)
            EndIf
        EndIf
    Next
    If (ambientsfxchn <> $00) Then
        If (channelplaying(ambientsfxchn) <> 0) Then
            stopchannel(ambientsfxchn)
        EndIf
    EndIf
    If (breathchn <> $00) Then
        If (channelplaying(breathchn) <> 0) Then
            stopchannel(breathchn)
        EndIf
    EndIf
    If (intercomstreamchn <> $00) Then
        stopstream_strict(intercomstreamchn)
        intercomstreamchn = $00
    EndIf
    For local5 = Each sound
        local5\Field3 = $00
        If (local5\Field0 <> $00) Then
            freesound(local5\Field0)
            local5\Field0 = $00
            local5\Field4 = $00
            Delete local5
        EndIf
    Next
    For local5 = Each sound
        For local0 = $00 To $1F Step $01
            If (local5\Field2[local0] <> $00) Then
                stopchannel(local5\Field2[local0])
            EndIf
        Next
    Next
    debuglog("Terminated all sounds")
    buttonsfx = loadsound_strict("SFX\Interact\Button.ogg")
    Return $00
End Function
