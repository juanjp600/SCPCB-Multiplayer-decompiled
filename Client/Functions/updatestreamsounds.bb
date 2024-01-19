Function updatestreamsounds%()
    Local local0.events
    If (10.0 < updatestreamsfactor) Then
        If (intercomstreamchn <> $00) Then
            setstreamvolume_strict(intercomstreamchn, sfxvolume)
        EndIf
        For local0 = Each events
            If (local0\Field5 <> $00) Then
                If (local0\Field9 <> 0) Then
                    setstreamvolume_strict(local0\Field5, sfxvolume)
                EndIf
            EndIf
            If (local0\Field6 <> $00) Then
                If (local0\Field10 <> 0) Then
                    setstreamvolume_strict(local0\Field6, sfxvolume)
                EndIf
            EndIf
        Next
        If (playerinreachableroom($00) = $00) Then
            If (((playerroom\Field7\Field11 <> "exit1") And (playerroom\Field7\Field11 <> "gatea")) <> 0) Then
                If (intercomstreamchn <> $00) Then
                    stopstream_strict(intercomstreamchn)
                    intercomstreamchn = $00
                EndIf
                If (playerroom\Field7\Field11 <> "dimension1499") Then
                    For local0 = Each events
                        If (((local0\Field5 <> $00) And local0\Field9) <> 0) Then
                            stopstream_strict(local0\Field5)
                            local0\Field5 = $00
                            local0\Field9 = $00
                        EndIf
                        If (((local0\Field6 <> $00) And local0\Field10) <> 0) Then
                            stopstream_strict(local0\Field6)
                            local0\Field6 = $00
                            local0\Field10 = $00
                        EndIf
                    Next
                EndIf
            EndIf
        EndIf
        updatestreamsfactor = 0.0
    Else
        updatestreamsfactor = (updatestreamsfactor + fpsfactor)
    EndIf
    Return $00
End Function
