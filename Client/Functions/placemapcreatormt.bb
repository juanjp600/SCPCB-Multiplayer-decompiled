Function placemapcreatormt%(arg0.rooms)
    Local local0.doors
    Local local1.items
    Local local2.waypoints
    Local local3%
    Local local4%
    Local local5%
    Local local6#
    Local local7%[7]
    Local local8#
    Local local9#
    Local local10%
    Local local11#
    Local local12%
    Local local14%
    catcherrors("PlaceMapCreatorMT()")
    For local5 = $00 To $06 Step $01
        local7[local5] = copyentity(misc_i\Field0[local5], $00)
        hideentity(local7[local5])
    Next
    For local4 = $00 To $12 Step $01
        For local3 = $00 To $12 Step $01
            If (arg0\Field18\Field0[((local4 * $13) + local3)] > $00) Then
                local10 = $00
                local11 = 0.0
                local10 = arg0\Field18\Field0[((local4 * $13) + local3)]
                local11 = ((Float arg0\Field18\Field1[((local4 * $13) + local3)]) * 90.0)
                local12 = copyentity(local7[(local10 - $01)], $00)
                rotateentity(local12, 0.0, local11, 0.0, $00)
                scaleentity(local12, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
                positionentity(local12, (arg0\Field3 + ((Float local3) * 2.0)), (arg0\Field4 + 8.0), (arg0\Field5 + ((Float local4) * 2.0)), $01)
                local8 = sin(entityyaw(local12, $01))
                local9 = cos(entityyaw(local12, $01))
                Select local10
                    Case $01,$02
                        addlight(arg0, (arg0\Field3 + ((Float local3) * 2.0)), ((arg0\Field4 + 8.0) + 1.597656), (arg0\Field5 + ((Float local4) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                    Case $03,$04,$05
                        addlight(arg0, (arg0\Field3 + ((Float local3) * 2.0)), ((arg0\Field4 + 8.0) + 1.65625), (arg0\Field5 + ((Float local4) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                    Case $06
                        addlight(arg0, (arg0\Field3 + ((Float local3) * 2.0)), ((arg0\Field4 + 8.0) + 1.597656), (arg0\Field5 + ((Float local4) * 2.0)), $02, 0.25, $FF, $C8, $C8, $01)
                        addlight(arg0, ((arg0\Field3 + ((Float local3) * 2.0)) + ((local9 * 560.0) * (1.0 / 256.0))), ((arg0\Field4 + 8.0) + 1.832031), ((arg0\Field5 + ((Float local4) * 2.0)) + ((local8 * 560.0) * (1.0 / 256.0))), $02, 0.25, $FF, $C8, $C8, $01)
                        createprop(arg0, "GFX\Map\Props\lamp_e.b3d", (((arg0\Field3 + ((Float local3) * 2.0)) + ((local8 * 252.0) * (1.0 / 256.0))) + ((local9 * 560.0) * (1.0 / 256.0))), ((arg0\Field4 + 8.0) + 1.6875), ((((Float local4) * 2.0) + ((local9 * 252.0) * (1.0 / 256.0))) + ((local8 * 560.0) * (1.0 / 256.0))), 0.0, 90.0, 90.0, 400.0, 400.0, 400.0, $00, $00, "")
                        createprop(arg0, "GFX\Map\Props\lamp_e.b3d", (((arg0\Field3 + ((Float local3) * 2.0)) - ((local8 * 252.0) * (1.0 / 256.0))) + ((local9 * 560.0) * (1.0 / 256.0))), ((arg0\Field4 + 8.0) + 1.6875), ((((Float local4) * 2.0) - ((local9 * 252.0) * (1.0 / 256.0))) + ((local8 * 560.0) * (1.0 / 256.0))), 0.0, -90.0, 90.0, 400.0, 400.0, 400.0, $00, $00, "")
                        local0 = createdoor(Null, ((arg0\Field3 + ((Float local3) * 2.0)) + ((local9 * 256.0) * (1.0 / 256.0))), (arg0\Field4 + 8.0), ((arg0\Field5 + ((Float local4) * 2.0)) + ((local8 * 256.0) * (1.0 / 256.0))), (entityyaw(local12, $01) - 90.0), $00, $01, $00, $00, $00)
                        positionentity(local0\Field24[$01], (entityx(local0\Field24[$01], $01) + (local9 * 0.05)), (entityy(local0\Field24[$01], $01) + 0.1), (entityz(local0\Field24[$01], $01) + (local8 * -0.28)), $01)
                        rotateentity(local0\Field24[$01], (entitypitch(local0\Field24[$01], $01) + 45.0), entityyaw(local0\Field24[$01], $01), entityroll(local0\Field24[$01], $01), $01)
                        local14 = createpivot($00)
                        positionentity(local14, ((arg0\Field3 + ((Float local3) * 2.0)) + ((local9 * 552.0) * (1.0 / 256.0))), ((arg0\Field4 + 8.0) + 0.9375), ((arg0\Field5 + ((Float local4) * 2.0)) + ((local8 * 552.0) * (1.0 / 256.0))), $00)
                        If (arg0\Field14[$01] = Null) Then
                            arg0\Field14[$01] = local0
                            arg0\Field11[$03] = local14
                            rotateentity(arg0\Field11[$03], 0.0, entityyaw(local12, $01), 0.0, $01)
                            positionentity(arg0\Field11[$00], (arg0\Field3 + ((Float local3) * 2.0)), (arg0\Field4 + 8.0), (arg0\Field5 + ((Float local4) * 2.0)), $01)
                        ElseIf (((arg0\Field14[$01] <> Null) And (arg0\Field14[$03] = Null)) <> 0) Then
                            arg0\Field14[$03] = local0
                            arg0\Field11[$05] = local14
                            rotateentity(arg0\Field11[$05], 0.0, (entityyaw(local12, $01) + 180.0), 0.0, $01)
                            positionentity(arg0\Field11[$01], (arg0\Field3 + ((Float local3) * 2.0)), (arg0\Field4 + 8.0), (arg0\Field5 + ((Float local4) * 2.0)), $01)
                        EndIf
                    Case $07
                        addlight(arg0, (((arg0\Field3 + ((Float local3) * 2.0)) - ((local8 * 521.0) * (1.0 / 256.0))) + ((local9 * 16.0) * (1.0 / 256.0))), ((arg0\Field4 + 8.0) + 1.546875), (((arg0\Field5 + ((Float local4) * 2.0)) + ((local9 * 521.0) * (1.0 / 256.0))) + ((local8 * 16.0) * (1.0 / 256.0))), $02, 0.425, $FF, $C8, $C8, $01)
                        createprop(arg0, "GFX\Map\Props\tank2.b3d", (((arg0\Field3 + ((Float local3) * 2.0)) - ((local8 * 369.0) * (1.0 / 256.0))) + ((local9 * 320.0) * (1.0 / 256.0))), ((arg0\Field4 + 8.0) - 0.5625), (((arg0\Field5 + ((Float local4) * 2.0)) + ((local9 * 369.0) * (1.0 / 256.0))) + ((local8 * 320.0) * (1.0 / 256.0))), 0.0, 0.0, 0.0, 3.0, 3.0, 3.0, $01, $00, "")
                        createprop(arg0, "GFX\Map\Props\tank2.b3d", (((arg0\Field3 + ((Float local3) * 2.0)) - ((local8 * 977.0) * (1.0 / 256.0))) + ((local9 * 320.0) * (1.0 / 256.0))), ((arg0\Field4 + 8.0) - 0.5625), (((arg0\Field5 + ((Float local4) * 2.0)) + ((local9 * 977.0) * (1.0 / 256.0))) + ((local8 * 320.0) * (1.0 / 256.0))), 0.0, 0.0, 0.0, 3.0, 3.0, 3.0, $01, $00, "")
                        local1 = createitem("SCP-500-01", $16, (((arg0\Field3 + ((Float local3) * 2.0)) + ((local9 * -208.0) * (1.0 / 256.0))) - ((local8 * 1226.0) * (1.0 / 256.0))), ((arg0\Field4 + 8.0) + (1.0 / 2.327273)), (((arg0\Field5 + ((Float local4) * 2.0)) + ((local8 * -208.0) * (1.0 / 256.0))) + ((local9 * 1226.0) * (1.0 / 256.0))), $00, $00, $00, 1.0, $00)
                        entitytype(local1\Field2, $03, $00)
                        local1 = createitem("Night Vision Goggles", $40, (((arg0\Field3 + ((Float local3) * 2.0)) - ((local8 * 504.0) * (1.0 / 256.0))) + ((local9 * 16.0) * (1.0 / 256.0))), ((arg0\Field4 + 8.0) + (1.0 / 2.844445)), (((arg0\Field5 + ((Float local4) * 2.0)) + ((local9 * 504.0) * (1.0 / 256.0))) + ((local8 * 16.0) * (1.0 / 256.0))), $00, $00, $00, 1.0, $00)
                        entitytype(local1\Field2, $03, $00)
                End Select
                arg0\Field18\Field3[((local4 * $13) + local3)] = local12
                local2 = createwaypoint(Null, arg0, (arg0\Field3 + ((Float local3) * 2.0)), ((arg0\Field4 + 8.0) + 0.2), (arg0\Field5 + ((Float local4) * 2.0)))
                arg0\Field18\Field4[((local4 * $13) + local3)] = local2
                If (local4 < $12) Then
                    If (arg0\Field18\Field4[(((local4 + $01) * $13) + local3)] <> Null) Then
                        local6 = entitydistance(arg0\Field18\Field4[((local4 * $13) + local3)]\Field0, arg0\Field18\Field4[(((local4 + $01) * $13) + local3)]\Field0)
                        For local5 = $00 To $03 Step $01
                            If (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[(((local4 + $01) * $13) + local3)]) Then
                                Exit
                            ElseIf (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = Null) Then
                                arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[(((local4 + $01) * $13) + local3)]
                                arg0\Field18\Field4[((local4 * $13) + local3)]\Field5[local5] = local6
                                Exit
                            EndIf
                        Next
                        For local5 = $00 To $03 Step $01
                            If (arg0\Field18\Field4[(((local4 + $01) * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[((local4 * $13) + local3)]) Then
                                Exit
                            ElseIf (arg0\Field18\Field4[(((local4 + $01) * $13) + local3)]\Field4[local5] = Null) Then
                                arg0\Field18\Field4[(((local4 + $01) * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[((local4 * $13) + local3)]
                                arg0\Field18\Field4[(((local4 + $01) * $13) + local3)]\Field5[local5] = local6
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                If (local4 > $00) Then
                    If (arg0\Field18\Field4[(((local4 - $01) * $13) + local3)] <> Null) Then
                        local6 = entitydistance(arg0\Field18\Field4[((local4 * $13) + local3)]\Field0, arg0\Field18\Field4[(((local4 - $01) * $13) + local3)]\Field0)
                        For local5 = $00 To $03 Step $01
                            If (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[(((local4 - $01) * $13) + local3)]) Then
                                Exit
                            ElseIf (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = Null) Then
                                arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[(((local4 - $01) * $13) + local3)]
                                arg0\Field18\Field4[((local4 * $13) + local3)]\Field5[local5] = local6
                                Exit
                            EndIf
                        Next
                        For local5 = $00 To $03 Step $01
                            If (arg0\Field18\Field4[(((local4 - $01) * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[((local4 * $13) + local3)]) Then
                                Exit
                            ElseIf (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = Null) Then
                                arg0\Field18\Field4[(((local4 - $01) * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[((local4 * $13) + local3)]
                                arg0\Field18\Field4[(((local4 - $01) * $13) + local3)]\Field5[local5] = local6
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                If (local3 > $00) Then
                    If (arg0\Field18\Field4[((local3 - $01) + (local4 * $13))] <> Null) Then
                        local6 = entitydistance(arg0\Field18\Field4[((local4 * $13) + local3)]\Field0, arg0\Field18\Field4[((local3 - $01) + (local4 * $13))]\Field0)
                        For local5 = $00 To $03 Step $01
                            If (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[((local3 - $01) + (local4 * $13))]) Then
                                Exit
                            ElseIf (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = Null) Then
                                arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[((local3 - $01) + (local4 * $13))]
                                arg0\Field18\Field4[((local4 * $13) + local3)]\Field5[local5] = local6
                                Exit
                            EndIf
                        Next
                        For local5 = $00 To $03 Step $01
                            If (arg0\Field18\Field4[((local3 - $01) + (local4 * $13))]\Field4[local5] = arg0\Field18\Field4[((local4 * $13) + local3)]) Then
                                Exit
                            ElseIf (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = Null) Then
                                arg0\Field18\Field4[((local3 - $01) + (local4 * $13))]\Field4[local5] = arg0\Field18\Field4[((local4 * $13) + local3)]
                                arg0\Field18\Field4[((local3 - $01) + (local4 * $13))]\Field5[local5] = local6
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                If (local3 < $12) Then
                    If (arg0\Field18\Field4[((local3 + $01) + (local4 * $13))] <> Null) Then
                        local6 = entitydistance(arg0\Field18\Field4[((local4 * $13) + local3)]\Field0, arg0\Field18\Field4[((local3 + $01) + (local4 * $13))]\Field0)
                        For local5 = $00 To $03 Step $01
                            If (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[((local3 + $01) + (local4 * $13))]) Then
                                Exit
                            ElseIf (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = Null) Then
                                arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = arg0\Field18\Field4[((local3 + $01) + (local4 * $13))]
                                arg0\Field18\Field4[((local4 * $13) + local3)]\Field5[local5] = local6
                                Exit
                            EndIf
                        Next
                        For local5 = $00 To $03 Step $01
                            If (arg0\Field18\Field4[((local3 + $01) + (local4 * $13))]\Field4[local5] = arg0\Field18\Field4[((local4 * $13) + local3)]) Then
                                Exit
                            ElseIf (arg0\Field18\Field4[((local4 * $13) + local3)]\Field4[local5] = Null) Then
                                arg0\Field18\Field4[((local3 + $01) + (local4 * $13))]\Field4[local5] = arg0\Field18\Field4[((local4 * $13) + local3)]
                                arg0\Field18\Field4[((local3 + $01) + (local4 * $13))]\Field5[local5] = local6
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
            EndIf
        Next
    Next
    For local5 = $00 To $06 Step $01
        arg0\Field18\Field2[local5] = local7[local5]
    Next
    catcherrors("Uncaught: PlaceMapCreatorMT()")
    Return $00
End Function
