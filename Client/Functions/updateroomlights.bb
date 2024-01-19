Function updateroomlights%(arg0.rooms)
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    If (arg0\Field73 = $00) Then
        arg0\Field73 = $01
        If ((enableroomlights And (0.5 < secondarylighton)) <> 0) Then
            For local0 = $00 To arg0\Field18 Step $01
                arg0\Field72 = $00
                local3 = entitydistance(collider, arg0\Field16[local0])
                If (hidedistance > local3) Then
                    templightvolume = (((arg0\Field17[local0] * arg0\Field17[local0]) * ((hidedistance - local3) / hidedistance)) + templightvolume)
                EndIf
                If (0.0 = updateroomlightstimer) Then
                    showentity(arg0\Field21[local0])
                    If (playerroom\Field7\Field11 = "173") Then
                        local1 = rnd(0.152, 0.168)
                    ElseIf (arg0\Field23[local0] < $05) Then
                        local1 = rnd(0.152, 0.168)
                    ElseIf (((arg0\Field23[local0] > $04) And (arg0\Field23[local0] < $0A)) <> 0) Then
                        local1 = rnd(0.14, 0.18)
                    Else
                        local1 = rnd(0.12, 0.2)
                    EndIf
                    scalesprite(arg0\Field21[local0], local1, local1)
                    local3 = ((entitydistance(camera, arg0\Field20[local0]) + 0.5) / 7.5)
                    local3 = max(min(local3, 1.0), 0.0)
                    local2 = inverse(local3)
                    If (0.0 < local2) Then
                        entityalpha(arg0\Field21[local0], (max(((Float ((brightness / $FF) * $03)) * (arg0\Field17[local0] / 2.0)), 1.0) * local2))
                    ElseIf (arg0\Field19[local0] = $00) Then
                        hideentity(arg0\Field21[local0])
                        arg0\Field19[local0] = $01
                    EndIf
                    If (arg0\Field56[local0] <> $00) Then
                        showentity(arg0\Field56[local0])
                    EndIf
                    If (arg0\Field57[local0] <> $00) Then
                        If (((0.0 < arg0\Field58[local0]) And (10.0 > arg0\Field58[local0])) <> 0) Then
                            showentity(arg0\Field57[local0])
                            arg0\Field58[local0] = (arg0\Field58[local0] + fpsfactor)
                        Else
                            hideentity(arg0\Field57[local0])
                            arg0\Field58[local0] = 0.0
                        EndIf
                    EndIf
                    If (arg0\Field56[local0] <> $00) Then
                        scaleentity(arg0\Field56[local0], (max(((-0.4 + local1) * 0.025), 0.0) + 0.005), (max(((-0.4 + local1) * 0.025), 0.0) + 0.005), (max(((-0.4 + local1) * 0.025), 0.0) + 0.005), $00)
                        If (arg0\Field23[local0] > $04) Then
                            If (rand($190, $01) = $01) Then
                                setemitter(arg0\Field20[local0], particleeffect[$00], $00, $00)
                                playsound2(introsfx(rand($0A, $0C)), camera, arg0\Field20[local0], 10.0, 1.0)
                                showentity(arg0\Field57[local0])
                                arg0\Field58[local0] = fpsfactor
                            EndIf
                        EndIf
                    EndIf
                Else
                    If (playerroom\Field7\Field11 = "173") Then
                        local1 = rnd(0.152, 0.168)
                    ElseIf (arg0\Field23[local0] < $05) Then
                        local1 = rnd(0.152, 0.168)
                    ElseIf (((arg0\Field23[local0] > $04) And (arg0\Field23[local0] < $0A)) <> 0) Then
                        local1 = rnd(0.14, 0.18)
                    Else
                        local1 = rnd(0.12, 0.2)
                    EndIf
                    If (arg0\Field19[local0] = $00) Then
                        scalesprite(arg0\Field21[local0], local1, local1)
                    EndIf
                    If (arg0\Field56[local0] <> $00) Then
                        scaleentity(arg0\Field56[local0], (max(((-0.4 + local1) * 0.025), 0.0) + 0.005), (max(((-0.4 + local1) * 0.025), 0.0) + 0.005), (max(((-0.4 + local1) * 0.025), 0.0) + 0.005), $00)
                    EndIf
                    If (arg0\Field57[local0] <> $00) Then
                        If (((0.0 < arg0\Field58[local0]) And (10.0 > arg0\Field58[local0])) <> 0) Then
                            showentity(arg0\Field57[local0])
                            arg0\Field58[local0] = (arg0\Field58[local0] + fpsfactor)
                        Else
                            hideentity(arg0\Field57[local0])
                            arg0\Field58[local0] = 0.0
                        EndIf
                    EndIf
                EndIf
                If (arg0\Field69 = $00) Then
                    showentity(arg0\Field16[local0])
                    hideentity(arg0\Field24[local0])
                    hideentity(arg0\Field21[local0])
                Else
                    showentity(arg0\Field16[local0])
                    showentity(arg0\Field24[local0])
                    showentity(arg0\Field21[local0])
                EndIf
                updateroomlightstimer = (updateroomlightstimer + fpsfactor)
                If (8.0 <= updateroomlightstimer) Then
                    updateroomlightstimer = 0.0
                EndIf
            Next
        Else
            For local0 = $00 To arg0\Field18 Step $01
                local3 = entitydistance(collider, arg0\Field16[local0])
                If (hidedistance > local3) Then
                    templightvolume = (((arg0\Field17[local0] * arg0\Field17[local0]) * ((hidedistance - local3) / hidedistance)) + templightvolume)
                EndIf
                If (0.5 >= secondarylighton) Then
                    hideentity(arg0\Field24[local0])
                Else
                    showentity(arg0\Field24[local0])
                EndIf
                hideentity(arg0\Field16[local0])
                hideentity(arg0\Field21[local0])
                arg0\Field19[local0] = $01
                If (arg0\Field56[local0] <> $00) Then
                    hideentity(arg0\Field56[local0])
                EndIf
                If (arg0\Field57[local0] <> $00) Then
                    hideentity(arg0\Field57[local0])
                EndIf
            Next
        EndIf
        arg0\Field71 = $00
    EndIf
    Return $00
End Function
