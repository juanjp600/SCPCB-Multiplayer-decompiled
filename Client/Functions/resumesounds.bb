Function resumesounds%()
    Local local0.events
    Local local1.npcs
    Local local2.doors
    Local local3.securitycams
    Local local4.rooms
    Local local5.soundemitters
    Local local6.emitter
    Local local7%
    For local0 = Each events
        If (local0\Field11 <> 0) Then
            If (local0\Field6 <> $00) Then
                setstreampaused_strict(local0\Field6, $00)
            EndIf
        Else
            resumechannel(local0\Field6)
        EndIf
        If (local0\Field12 <> 0) Then
            If (local0\Field7 <> $00) Then
                setstreampaused_strict(local0\Field7, $00)
            EndIf
        Else
            resumechannel(local0\Field7)
        EndIf
        resumechannel(local0\Field10)
    Next
    For local1 = Each npcs
        If (local1\Field21 <> 0) Then
            If (local1\Field18 <> $00) Then
                setstreampaused_strict(local1\Field18, $00)
            EndIf
        Else
            resumechannel(local1\Field18)
        EndIf
        If (local1\Field22 <> 0) Then
            If (local1\Field20 <> $00) Then
                setstreampaused_strict(local1\Field20, $00)
            EndIf
        Else
            resumechannel(local1\Field20)
        EndIf
    Next
    For local2 = Each doors
        resumechannel(local2\Field17)
        resumechannel(local2\Field18)
    Next
    For local3 = Each securitycams
        resumechannel(local3\Field13)
    Next
    For local4 = Each rooms
        resumechannel(local4\Field9)
    Next
    For local5 = Each soundemitters
        resumechannel(local5\Field3)
    Next
    For local6 = Each emitter
        resumechannel(local6\Field12)
    Next
    resumechannel(ambientsfxchn)
    resumechannel(breathchn)
    resumechannel(breathgasrelaxedchn)
    resumechannel(vomitchn)
    resumechannel(coughchn)
    resumechannel(scramblechn)
    For local7 = $00 To $01 Step $01
        resumechannel(lowbatterychn[local7])
        resumechannel(i_427\Field3[local7])
    Next
    resumechannel(i_1048a\Field2)
    If (isusingradio <> 0) Then
        For local7 = $00 To $05 Step $01
            If ((Float local7) = selecteditem\Field13) Then
                resumechannel(radiochn[local7])
            EndIf
        Next
        stopchannel(radiochn[$06])
        radiochn[$06] = $00
    EndIf
    If (intercomstreamchn <> $00) Then
        setstreampaused_strict(intercomstreamchn, $00)
    EndIf
    Return $00
End Function
