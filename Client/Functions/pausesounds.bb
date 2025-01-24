Function pausesounds%()
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
                setstreampaused_strict(local0\Field6, $01)
            EndIf
        Else
            pausechannel(local0\Field6)
        EndIf
        If (local0\Field12 <> 0) Then
            If (local0\Field7 <> $00) Then
                setstreampaused_strict(local0\Field7, $01)
            EndIf
        Else
            pausechannel(local0\Field7)
        EndIf
        pausechannel(local0\Field10)
    Next
    For local1 = Each npcs
        If (local1\Field21 <> 0) Then
            If (local1\Field18 <> $00) Then
                setstreampaused_strict(local1\Field18, $01)
            EndIf
        Else
            pausechannel(local1\Field18)
        EndIf
        If (local1\Field22 <> 0) Then
            If (local1\Field20 <> $00) Then
                setstreampaused_strict(local1\Field20, $01)
            EndIf
        Else
            pausechannel(local1\Field20)
        EndIf
    Next
    For local2 = Each doors
        pausechannel(local2\Field17)
        pausechannel(local2\Field18)
    Next
    For local3 = Each securitycams
        pausechannel(local3\Field13)
    Next
    For local4 = Each rooms
        pausechannel(local4\Field9)
    Next
    For local5 = Each soundemitters
        pausechannel(local5\Field3)
    Next
    For local6 = Each emitter
        pausechannel(local6\Field12)
    Next
    pausechannel(ambientsfxchn)
    pausechannel(breathchn)
    pausechannel(breathgasrelaxedchn)
    pausechannel(vomitchn)
    pausechannel(coughchn)
    pausechannel(scramblechn)
    For local7 = $00 To $01 Step $01
        pausechannel(lowbatterychn[local7])
        pausechannel(i_427\Field3[local7])
    Next
    pausechannel(i_1048a\Field2)
    For local7 = $00 To $06 Step $01
        pausechannel(radiochn[local7])
    Next
    If (intercomstreamchn <> $00) Then
        setstreampaused_strict(intercomstreamchn, $01)
    EndIf
    Return $00
End Function
