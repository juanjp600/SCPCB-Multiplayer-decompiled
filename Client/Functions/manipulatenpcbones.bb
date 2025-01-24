Function manipulatenpcbones%()
    Local local0.npcs
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5%
    Local local6%
    Local local7%
    Local local8$
    Local local9#
    Local local10%
    Local local11%
    For local0 = Each npcs
        If (local0\Field52 <> 0) Then
            local8 = getnpcmanipulationvalue(local0\Field58, local0\Field54, "bonename", $00)
            If (local8 <> "") Then
                local7 = createpivot($00)
                local6 = findchild(local0\Field0, local8)
                If (local6 = $00) Then
                    runtimeerrorex(format(getlocalstring("runerr", "spawn.bone.notexist"), local8, "%s"))
                EndIf
                positionentity(local7, entityx(local6, $01), entityy(local6, $01), entityz(local6, $01), $00)
                local10 = local0\Field53
                If (local10 = $00) Then
                    local11 = (Int getnpcmanipulationvalue(local0\Field58, local0\Field54, "controller_max", $01))
                    For local5 = $01 To local11 Step $01
                        If (getnpcmanipulationvalue(local0\Field58, local0\Field54, ("controlleraxis" + (Str local5)), $00) = "pitch") Then
                            local1 = (Float getnpcmanipulationvalue(local0\Field58, local0\Field54, (("controlleraxis" + (Str local5)) + "_max"), $02))
                            local2 = (Float getnpcmanipulationvalue(local0\Field58, local0\Field54, (("controlleraxis" + (Str local5)) + "_min"), $02))
                            local3 = (Float getnpcmanipulationvalue(local0\Field58, local0\Field54, (("controlleraxis" + (Str local5)) + "_offset"), $02))
                            If ((Int getnpcmanipulationvalue(local0\Field58, local0\Field54, (("controlleraxis" + (Str local5)) + "_inverse"), $03)) <> 0) Then
                                local9 = ((- deltapitch(local6, camera)) + local3)
                            Else
                                local9 = (deltapitch(local6, camera) + local3)
                            EndIf
                            local4 = (Float getnpcmanipulationvalue(local0\Field58, local0\Field54, (("controlleraxis" + (Str local5)) + "_smoothing"), $02))
                            If (0.0 < local4) Then
                                local0\Field55 = curveangle(local9, local0\Field55, local4)
                            Else
                                local0\Field55 = local9
                            EndIf
                            local0\Field55 = changeanglevalueforcorrectboneassigning(local0\Field55)
                            local0\Field55 = clamp(local0\Field55, local2, local1)
                        ElseIf (getnpcmanipulationvalue(local0\Field58, local0\Field54, "controlleraxis1", $00) = "yaw") Then
                            local1 = (Float getnpcmanipulationvalue(local0\Field58, local0\Field54, (("controlleraxis" + (Str local5)) + "_max"), $02))
                            local2 = (Float getnpcmanipulationvalue(local0\Field58, local0\Field54, (("controlleraxis" + (Str local5)) + "_min"), $02))
                            local3 = (Float getnpcmanipulationvalue(local0\Field58, local0\Field54, (("controlleraxis" + (Str local5)) + "_offset"), $02))
                            If ((Int getnpcmanipulationvalue(local0\Field58, local0\Field54, (("controlleraxis" + (Str local5)) + "_inverse"), $03)) <> 0) Then
                                local9 = ((- deltayaw(local6, camera)) + local3)
                            Else
                                local9 = (deltayaw(local6, camera) + local3)
                            EndIf
                            local4 = (Float getnpcmanipulationvalue(local0\Field58, local0\Field54, (("controlleraxis" + (Str local5)) + "_smoothing"), $02))
                            If (0.0 < local4) Then
                                local0\Field56 = curveangle(local9, local0\Field56, local4)
                            Else
                                local0\Field56 = local9
                            EndIf
                            local0\Field56 = changeanglevalueforcorrectboneassigning(local0\Field56)
                            local0\Field56 = clamp(local0\Field56, local2, local1)
                        EndIf
                    Next
                    rotateentity(local6, (entitypitch(local6, $00) + local0\Field55), (entityyaw(local6, $00) + local0\Field56), (entityroll(local6, $00) + local0\Field57), $00)
                EndIf
                freeentity(local7)
                local7 = $00
            EndIf
        EndIf
    Next
    Return $00
End Function
