Function killsounds%(arg0%)
    Local local0.events
    Local local1.npcs
    Local local2.doors
    Local local3.sound
    Local local4.securitycams
    Local local5.rooms
    Local local6.soundemitters
    Local local7.emitter
    Local local8%
    For local8 = $00 To $09 Step $01
        If (tempsounds[local8] <> $00) Then
            freesound_strict(tempsounds[local8])
            tempsounds[local8] = $00
        EndIf
    Next
    For local0 = Each events
        If (local0\Field11 <> 0) Then
            If (local0\Field6 <> $00) Then
                stopstream_strict(local0\Field6)
                local0\Field11 = $00
            EndIf
        Else
            stopchannel(local0\Field6)
        EndIf
        local0\Field6 = $00
        If (local0\Field12 <> 0) Then
            If (local0\Field7 <> $00) Then
                stopstream_strict(local0\Field7)
                local0\Field12 = $00
            EndIf
        Else
            stopchannel(local0\Field7)
        EndIf
        local0\Field7 = $00
        stopchannel(local0\Field10)
        local0\Field10 = $00
    Next
    For local1 = Each npcs
        If (local1\Field21 <> 0) Then
            If (local1\Field18 <> $00) Then
                stopstream_strict(local1\Field18)
                local1\Field21 = $00
            EndIf
        Else
            stopchannel(local1\Field18)
        EndIf
        local1\Field18 = $00
        If (local1\Field22 <> 0) Then
            If (local1\Field20 <> $00) Then
                stopstream_strict(local1\Field20)
                local1\Field22 = $00
            EndIf
        Else
            stopchannel(local1\Field20)
        EndIf
        local1\Field20 = $00
    Next
    For local2 = Each doors
        stopchannel(local2\Field17)
        local2\Field17 = $00
        stopchannel(local2\Field18)
        local2\Field18 = $00
    Next
    For local4 = Each securitycams
        stopchannel(local4\Field13)
        local4\Field13 = $00
    Next
    For local5 = Each rooms
        stopchannel(local5\Field9)
        local5\Field9 = $00
    Next
    For local6 = Each soundemitters
        stopchannel(local6\Field3)
        local6\Field3 = $00
    Next
    For local7 = Each emitter
        stopchannel(local7\Field12)
        local7\Field12 = $00
    Next
    stopchannel(ambientsfxchn)
    ambientsfxchn = $00
    stopchannel(breathchn)
    breathchn = $00
    stopchannel(breathgasrelaxedchn)
    breathgasrelaxedchn = $00
    stopchannel(vomitchn)
    vomitchn = $00
    stopchannel(coughchn)
    coughchn = $00
    stopchannel(scramblechn)
    scramblechn = $00
    For local8 = $00 To $01 Step $01
        stopchannel(lowbatterychn[local8])
        lowbatterychn[local8] = $00
        stopchannel(i_427\Field3[local8])
        i_427\Field3[local8] = $00
    Next
    stopchannel(i_1048a\Field2)
    i_1048a\Field2 = $00
    For local8 = $00 To $06 Step $01
        stopchannel(radiochn[local8])
        radiochn[local8] = $00
    Next
    If (intercomstreamchn <> $00) Then
        stopstream_strict(intercomstreamchn)
        intercomstreamchn = $00
    EndIf
    If (arg0 <> 0) Then
        If (opt\Field22 <> 0) Then
            For local3 = Each sound
                If (local3\Field0 <> $00) Then
                    freesound(local3\Field0)
                    local3\Field0 = $00
                    removesubtitlestoken(local3)
                EndIf
                local3\Field3 = $00
            Next
        EndIf
    EndIf
    For local3 = Each sound
        For local8 = $00 To $0F Step $01
            stopchannel(local3\Field2[local8])
            local3\Field2[local8] = $00
        Next
    Next
    clearsubtitles()
    Return $00
End Function
