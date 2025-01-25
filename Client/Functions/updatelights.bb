Function updatelights%(arg0%)
    Local local0.lights
    Local local1%
    Local local2#
    Local local3#
    Local local4%
    Local local5#
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    For local0 = Each lights
        If (0.3 < secondarylighton) Then
            If (local0\Field12 <> Null) Then
                If (((8.0 > local0\Field12\Field8) Lor (local0\Field12 = playerroom)) <> 0) Then
                    If (local0\Field1 <> $00) Then
                        If (arg0 = camera) Then
                            entityorder(local0\Field2, $FFFFFFFF)
                            If (0.0 = updatelightstimer) Then
                                local5 = entitydistancesquared(arg0, local0\Field0)
                                local6 = entityhidden(local0\Field1)
                                local7 = entityhidden(local0\Field2)
                                local4 = entityhidden(local0\Field0)
                                If (local5 < (lightrenderdistance * lightvolume)) Then
                                    entityautofade(local0\Field1, (0.1 * lightvolume), (fog\Field0 * lightvolume))
                                    local8 = entityvisible(arg0, local0\Field0)
                                    local9 = entityinview(local0\Field0, arg0)
                                    If (local4 <> 0) Then
                                        showentity(local0\Field0)
                                    EndIf
                                    If (((local0\Field11 And (rand($32, $01) = $01)) And local8) <> 0) Then
                                        If (local4 = $00) Then
                                            hideentity(local0\Field0)
                                        EndIf
                                        playsoundex(snd_i\Field33[rand($00, $02)], arg0, local0\Field0, 4.0, 1.0, $00, $00)
                                        If (local9 <> 0) Then
                                            If (local6 = $00) Then
                                                hideentity(local0\Field1)
                                            EndIf
                                            If (local7 = $00) Then
                                                hideentity(local0\Field2)
                                            EndIf
                                        EndIf
                                        local2 = rnd(0.35, 0.8)
                                        secondarylighton = clamp((secondarylighton - local2), 0.301, 1.0)
                                        templightvolume = clamp((templightvolume - local2), 0.5, 1.0)
                                        setemitter(Null, entityx(local0\Field0, $01), entityy(local0\Field0, $01), entityz(local0\Field0, $01), $14)
                                    EndIf
                                    If ((local9 And local8) <> 0) Then
                                        If (local6 <> 0) Then
                                            showentity(local0\Field1)
                                        EndIf
                                        If (opt\Field4 <> 0) Then
                                            local3 = (1.0 - clamp(((sqr(local5) + 0.5) / 7.5), 0.0, 1.0))
                                            If (0.0 < local3) Then
                                                If (local7 <> 0) Then
                                                    showentity(local0\Field2)
                                                EndIf
                                                entityalpha(local0\Field2, (max(((((((fog\Field9 + fog\Field10) + fog\Field11) / 3.0) / 255.0) * 3.0) * (local0\Field10 / 2.0)), 1.0) * local3))
                                                local2 = rnd(0.36, 0.4)
                                                scalesprite(local0\Field2, local2, local2)
                                            ElseIf (local7 = $00) Then
                                                hideentity(local0\Field2)
                                            EndIf
                                        ElseIf (local7 = $00) Then
                                            hideentity(local0\Field2)
                                        EndIf
                                    Else
                                        If (local6 = $00) Then
                                            hideentity(local0\Field1)
                                        EndIf
                                        If (local7 = $00) Then
                                            hideentity(local0\Field2)
                                        EndIf
                                    EndIf
                                ElseIf (local4 = $00) Then
                                    hideentity(local0\Field0)
                                EndIf
                            EndIf
                        Else
                            entityorder(local0\Field2, $00)
                        EndIf
                    ElseIf (arg0 = camera) Then
                        If (0.0 = updatelightstimer) Then
                            local4 = entityhidden(local0\Field0)
                            If ((lightrenderdistance * lightvolume) > entitydistancesquared(arg0, local0\Field0)) Then
                                If (local4 <> 0) Then
                                    showentity(local0\Field0)
                                EndIf
                                If (((local0\Field11 And (rand($32, $01) = $01)) And entityvisible(arg0, local0\Field0)) <> 0) Then
                                    If (local4 = $00) Then
                                        hideentity(local0\Field0)
                                    EndIf
                                    playsoundex(snd_i\Field33[rand($00, $02)], arg0, local0\Field0, 4.0, 1.0, $00, $00)
                                    local2 = rnd(0.35, 0.8)
                                    secondarylighton = clamp((secondarylighton - local2), 0.301, 1.0)
                                    templightvolume = clamp((templightvolume - local2), 0.5, 1.0)
                                EndIf
                            ElseIf (local4 = $00) Then
                                hideentity(local0\Field0)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        Else
            If (local0\Field1 <> $00) Then
                If (entityhidden(local0\Field1) = $00) Then
                    hideentity(local0\Field1)
                EndIf
                If (entityhidden(local0\Field2) = $00) Then
                    hideentity(local0\Field2)
                EndIf
            EndIf
            If (entityhidden(local0\Field0) = $00) Then
                hideentity(local0\Field0)
            EndIf
        EndIf
    Next
    Return $00
End Function
