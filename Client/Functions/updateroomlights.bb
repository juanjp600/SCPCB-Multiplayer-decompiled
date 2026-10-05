Function updateroomlights%(arg0.rooms)
    Local local0%
    Local local1#
    Local local2%
    Local local3#
    Local local4%
    If (((arg0\Field73 = $00) Or (arg0\Field69 = $00)) <> 0) Then
        If (arg0\Field69 = $00) Then
            For local0 = $00 To arg0\Field18 Step $01
                hideentity(arg0\Field16[local0])
                hideentity(arg0\Field24[local0])
                hideentity(arg0\Field21[local0])
                If (arg0\Field56[local0] <> $00) Then
                    hideentity(arg0\Field56[local0])
                EndIf
                If (arg0\Field57[local0] <> $00) Then
                    hideentity(arg0\Field57[local0])
                EndIf
            Next
            arg0\Field73 = $01
            Return $00
        EndIf
        arg0\Field73 = $01
        If ((enableroomlights And (0.5 < secondarylighton)) <> 0) Then
            For local0 = $00 To arg0\Field18 Step $01
                arg0\Field72 = $00
                If (0.0 = updateroomlightstimer) Then
                    local3 = entitydistancesquared(camera, arg0\Field20[local0])
                    If (800.0 > local3) Then
                        If (entityvisible(camera, arg0\Field20[local0]) = $00) Then
                            showentity(arg0\Field24[local0])
                            hideentity(arg0\Field21[local0])
                        Else
                            local4 = arg0\Field23[local0]
                            If (local4 < $05) Then
                                local1 = rnd(0.62, 0.7)
                            ElseIf (local4 < $0A) Then
                                local1 = rnd(0.58, 0.74)
                            Else
                                local1 = rnd(0.52, 0.8)
                            EndIf
                            scalesprite(arg0\Field21[local0], local1, local1)
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
                                        If (arg0\Field57[local0] <> $00) Then
                                            showentity(arg0\Field57[local0])
                                        EndIf
                                        arg0\Field58[local0] = fpsfactor
                                    EndIf
                                EndIf
                            EndIf
                            showentity(arg0\Field16[local0])
                            showentity(arg0\Field21[local0])
                        EndIf
                    Else
                        hideentity(arg0\Field16[local0])
                        hideentity(arg0\Field24[local0])
                        hideentity(arg0\Field21[local0])
                    EndIf
                EndIf
            Next
            updateroomlightstimer = (updateroomlightstimer + fpsfactor)
            If (12.0 <= updateroomlightstimer) Then
                updateroomlightstimer = 0.0
            EndIf
        Else
            For local0 = $00 To arg0\Field18 Step $01
                local3 = entitydistancesquared(collider, arg0\Field20[local0])
                If (800.0 > local3) Then
                    templightvolume = (((arg0\Field17[local0] * arg0\Field17[local0]) * ((hidedistance - local3) / hidedistance)) + templightvolume)
                    If (0.5 >= secondarylighton) Then
                        hideentity(arg0\Field24[local0])
                    Else
                        showentity(arg0\Field24[local0])
                    EndIf
                Else
                    hideentity(arg0\Field24[local0])
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
