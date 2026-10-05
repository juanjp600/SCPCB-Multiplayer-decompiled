Function placegrid_mapcreator%(arg0.rooms)
    Local local0%
    Local local1%
    Local local2%
    Local local3%[7]
    Local local4.doors
    Local local5.items
    Local local6%
    Local local7%
    Local local8%
    Local local10%
    Local local11.waypoints
    Local local12%
    For local2 = $00 To $06 Step $01
        local3[local2] = copyentity(objtunnel(local2), $00)
        hideentity(local3[local2])
    Next
    For local1 = $00 To $12 Step $01
        For local0 = $00 To $12 Step $01
            If (arg0\Field33\Field0[((local1 * $13) + local0)] > $00) Then
                local6 = $00
                local7 = $00
                local6 = arg0\Field33\Field0[((local1 * $13) + local0)]
                local7 = (Int ((Float arg0\Field33\Field1[((local1 * $13) + local0)]) * 90.0))
                local8 = copyentity(local3[(local6 - $01)], $00)
                rotateentity(local8, 0.0, (Float local7), 0.0, $00)
                scaleentity(local8, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $01)
                positionentity(local8, (arg0\Field4 + ((Float local0) * 2.0)), 8.0, (arg0\Field6 + ((Float local1) * 2.0)), $01)
                Select arg0\Field33\Field0[((local1 * $13) + local0)]
                    Case $01
                        addlight(Null, (arg0\Field4 + ((Float local0) * 2.0)), 9.4375, (arg0\Field6 + ((Float local1) * 2.0)), $02, (1.0 / 0.512), $FF, $FF, $FF, $00)
                    Case $02,$03
                        addlight(Null, (arg0\Field4 + ((Float local0) * 2.0)), 9.4375, (arg0\Field6 + ((Float local1) * 2.0)), $02, (1.0 / 0.512), $FF, $FF, $FF, $00)
                    Case $03
                        addlight(Null, (arg0\Field4 + ((Float local0) * 2.0)), 9.609375, (arg0\Field6 + ((Float local1) * 2.0)), $02, (1.0 / 0.512), $FF, $FF, $FF, $00)
                    Case $04,$05
                        addlight(Null, (arg0\Field4 + ((Float local0) * 2.0)), 9.609375, (arg0\Field6 + ((Float local1) * 2.0)), $02, (1.0 / 0.512), $FF, $FF, $FF, $00)
                    Case $06
                        local4 = createdoor(arg0\Field0, ((arg0\Field4 + ((Float local0) * 2.0)) + ((cos(entityyaw(local8, $01)) * 240.0) * (1.0 / 256.0))), 8.0, ((arg0\Field6 + ((Float local1) * 2.0)) + ((sin(entityyaw(local8, $01)) * 240.0) * (1.0 / 256.0))), (entityyaw(local8, $01) + 90.0), Null, $00, $03, $00, "")
                        positionentity(local4\Field3[$00], (entityx(local4\Field3[$00], $01) + (cos(entityyaw(local8, $01)) * 0.05)), (entityy(local4\Field3[$00], $01) + 0.0), (entityz(local4\Field3[$00], $01) + (sin(entityyaw(local8, $01)) * 0.05)), $01)
                        addlight(Null, ((arg0\Field4 + ((Float local0) * 2.0)) + ((cos(entityyaw(local8, $01)) * 555.0) * (1.0 / 256.0))), 9.832031, ((arg0\Field6 + ((Float local1) * 2.0)) + ((sin(entityyaw(local8, $01)) * 555.0) * (1.0 / 256.0))), $02, 2.34375, $FF, $FF, $FF, $00)
                        local10 = createpivot($00)
                        rotateentity(local10, 0.0, (entityyaw(local8, $01) + 180.0), 0.0, $01)
                        positionentity(local10, ((arg0\Field4 + ((Float local0) * 2.0)) + ((cos(entityyaw(local8, $01)) * 552.0) * (1.0 / 256.0))), 8.9375, ((arg0\Field6 + ((Float local1) * 2.0)) + ((sin(entityyaw(local8, $01)) * 552.0) * (1.0 / 256.0))), $00)
                        If (arg0\Field29[$01] = Null) Then
                            arg0\Field29[$01] = local4
                            adddoortooptsystem(arg0, local4)
                            arg0\Field25[$03] = local10
                            positionentity(arg0\Field25[$00], (arg0\Field4 + ((Float local0) * 2.0)), 8.0, (arg0\Field6 + ((Float local1) * 2.0)), $01)
                        ElseIf (((arg0\Field29[$01] <> Null) And (arg0\Field29[$03] = Null)) <> 0) Then
                            arg0\Field29[$03] = local4
                            adddoortooptsystem(arg0, local4)
                            arg0\Field25[$05] = local10
                            positionentity(arg0\Field25[$01], (arg0\Field4 + ((Float local0) * 2.0)), 8.0, (arg0\Field6 + ((Float local1) * 2.0)), $01)
                        EndIf
                    Case $07
                        addlight(Null, (((arg0\Field4 + ((Float local0) * 2.0)) - ((sin(entityyaw(local8, $01)) * 504.0) * (1.0 / 256.0))) + ((cos(entityyaw(local8, $01)) * 16.0) * (1.0 / 256.0))), 9.546875, (((arg0\Field6 + ((Float local1) * 2.0)) + ((cos(entityyaw(local8, $01)) * 504.0) * (1.0 / 256.0))) + ((sin(entityyaw(local8, $01)) * 16.0) * (1.0 / 256.0))), $02, (1.0 / 0.512), $FF, $C8, $C8, $00)
                        local5 = createitem("SCP-500-01", "scp500", (((arg0\Field4 + ((Float local0) * 2.0)) + ((cos(entityyaw(local8, $01)) * -208.0) * (1.0 / 256.0))) - ((sin(entityyaw(local8, $01)) * 1226.0) * (1.0 / 256.0))), 8.3125, (((arg0\Field6 + ((Float local1) * 2.0)) + ((sin(entityyaw(local8, $01)) * -208.0) * (1.0 / 256.0))) + ((cos(entityyaw(local8, $01)) * 1226.0) * (1.0 / 256.0))), $00, $00, $00, 1.0, $00, $01)
                        entitytype(local5\Field2, $03, $00)
                        local5 = createitem("Night Vision Goggles", "nvgoggles", (((arg0\Field4 + ((Float local0) * 2.0)) - ((sin(entityyaw(local8, $01)) * 504.0) * (1.0 / 256.0))) + ((cos(entityyaw(local8, $01)) * 16.0) * (1.0 / 256.0))), 8.3125, (((arg0\Field6 + ((Float local1) * 2.0)) + ((cos(entityyaw(local8, $01)) * 504.0) * (1.0 / 256.0))) + ((sin(entityyaw(local8, $01)) * 16.0) * (1.0 / 256.0))), $00, $00, $00, 1.0, $00, $01)
                        entitytype(local5\Field2, $03, $00)
                End Select
                arg0\Field33\Field3[((local1 * $13) + local0)] = local8
                local11 = createwaypoint((arg0\Field4 + ((Float local0) * 2.0)), 8.2, (arg0\Field6 + ((Float local1) * 2.0)), Null, arg0)
                arg0\Field33\Field4[((local1 * $13) + local0)] = local11
                If (local1 < $12) Then
                    If (arg0\Field33\Field4[(((local1 + $01) * $13) + local0)] <> Null) Then
                        local12 = (Int entitydistance(arg0\Field33\Field4[((local1 * $13) + local0)]\Field0, arg0\Field33\Field4[(((local1 + $01) * $13) + local0)]\Field0))
                        For local2 = $00 To $03 Step $01
                            If (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[(((local1 + $01) * $13) + local0)]) Then
                                Exit
                            ElseIf (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = Null) Then
                                arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[(((local1 + $01) * $13) + local0)]
                                arg0\Field33\Field4[((local1 * $13) + local0)]\Field5[local2] = (Float local12)
                                Exit
                            EndIf
                        Next
                        For local2 = $00 To $03 Step $01
                            If (arg0\Field33\Field4[(((local1 + $01) * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[((local1 * $13) + local0)]) Then
                                Exit
                            ElseIf (arg0\Field33\Field4[(((local1 + $01) * $13) + local0)]\Field4[local2] = Null) Then
                                arg0\Field33\Field4[(((local1 + $01) * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[((local1 * $13) + local0)]
                                arg0\Field33\Field4[(((local1 + $01) * $13) + local0)]\Field5[local2] = (Float local12)
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                If (local1 > $00) Then
                    If (arg0\Field33\Field4[(((local1 - $01) * $13) + local0)] <> Null) Then
                        local12 = (Int entitydistance(arg0\Field33\Field4[((local1 * $13) + local0)]\Field0, arg0\Field33\Field4[(((local1 - $01) * $13) + local0)]\Field0))
                        For local2 = $00 To $03 Step $01
                            If (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[(((local1 - $01) * $13) + local0)]) Then
                                Exit
                            ElseIf (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = Null) Then
                                arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[(((local1 - $01) * $13) + local0)]
                                arg0\Field33\Field4[((local1 * $13) + local0)]\Field5[local2] = (Float local12)
                                Exit
                            EndIf
                        Next
                        For local2 = $00 To $03 Step $01
                            If (arg0\Field33\Field4[(((local1 - $01) * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[((local1 * $13) + local0)]) Then
                                Exit
                            ElseIf (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = Null) Then
                                arg0\Field33\Field4[(((local1 - $01) * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[((local1 * $13) + local0)]
                                arg0\Field33\Field4[(((local1 - $01) * $13) + local0)]\Field5[local2] = (Float local12)
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                If (local0 > $00) Then
                    If (arg0\Field33\Field4[((local0 - $01) + (local1 * $13))] <> Null) Then
                        local12 = (Int entitydistance(arg0\Field33\Field4[((local1 * $13) + local0)]\Field0, arg0\Field33\Field4[((local0 - $01) + (local1 * $13))]\Field0))
                        For local2 = $00 To $03 Step $01
                            If (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[((local0 - $01) + (local1 * $13))]) Then
                                Exit
                            ElseIf (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = Null) Then
                                arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[((local0 - $01) + (local1 * $13))]
                                arg0\Field33\Field4[((local1 * $13) + local0)]\Field5[local2] = (Float local12)
                                Exit
                            EndIf
                        Next
                        For local2 = $00 To $03 Step $01
                            If (arg0\Field33\Field4[((local0 - $01) + (local1 * $13))]\Field4[local2] = arg0\Field33\Field4[((local1 * $13) + local0)]) Then
                                Exit
                            ElseIf (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = Null) Then
                                arg0\Field33\Field4[((local0 - $01) + (local1 * $13))]\Field4[local2] = arg0\Field33\Field4[((local1 * $13) + local0)]
                                arg0\Field33\Field4[((local0 - $01) + (local1 * $13))]\Field5[local2] = (Float local12)
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                If (local0 < $12) Then
                    If (arg0\Field33\Field4[((local0 + $01) + (local1 * $13))] <> Null) Then
                        local12 = (Int entitydistance(arg0\Field33\Field4[((local1 * $13) + local0)]\Field0, arg0\Field33\Field4[((local0 + $01) + (local1 * $13))]\Field0))
                        For local2 = $00 To $03 Step $01
                            If (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[((local0 + $01) + (local1 * $13))]) Then
                                Exit
                            ElseIf (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = Null) Then
                                arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = arg0\Field33\Field4[((local0 + $01) + (local1 * $13))]
                                arg0\Field33\Field4[((local1 * $13) + local0)]\Field5[local2] = (Float local12)
                                Exit
                            EndIf
                        Next
                        For local2 = $00 To $03 Step $01
                            If (arg0\Field33\Field4[((local0 + $01) + (local1 * $13))]\Field4[local2] = arg0\Field33\Field4[((local1 * $13) + local0)]) Then
                                Exit
                            ElseIf (arg0\Field33\Field4[((local1 * $13) + local0)]\Field4[local2] = Null) Then
                                arg0\Field33\Field4[((local0 + $01) + (local1 * $13))]\Field4[local2] = arg0\Field33\Field4[((local1 * $13) + local0)]
                                arg0\Field33\Field4[((local0 + $01) + (local1 * $13))]\Field5[local2] = (Float local12)
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
            EndIf
        Next
    Next
    For local2 = $00 To $06 Step $01
        arg0\Field33\Field2[local2] = local3[local2]
    Next
    Return $00
End Function
