Function updatestreamsounds%()
    Local local0.events
    Local local1%
    Local local2#
    If (0.0 < fps\Field7[$00]) Then
        local1 = ((playerinreachableroom($01, $00) = $00) And (isplayeroutsidefacility() = $00))
        If (intercomstreamchn <> $00) Then
            setstreamvolume_strict(intercomstreamchn, (opt\Field21 * opt\Field16))
            If (local1 <> 0) Then
                stopstream_strict(intercomstreamchn)
                intercomstreamchn = $00
            EndIf
        EndIf
        local2 = (opt\Field20 * opt\Field16)
        For local0 = Each events
            If (local0\Field11 <> 0) Then
                If (local0\Field6 <> $00) Then
                    setstreamvolume_strict(local0\Field6, local2)
                    If ((local1 And (playerroom\Field7\Field6 <> $6A)) <> 0) Then
                        stopstream_strict(local0\Field6)
                        local0\Field6 = $00
                        local0\Field11 = $00
                    EndIf
                EndIf
            EndIf
            If (local0\Field12 <> 0) Then
                If (local0\Field7 <> $00) Then
                    setstreamvolume_strict(local0\Field7, local2)
                    If ((local1 And (playerroom\Field7\Field6 <> $6A)) <> 0) Then
                        stopstream_strict(local0\Field7)
                        local0\Field7 = $00
                        local0\Field12 = $00
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    Return $00
End Function
