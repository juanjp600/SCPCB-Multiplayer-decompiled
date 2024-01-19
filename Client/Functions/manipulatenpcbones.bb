Function manipulatenpcbones%(arg0.npcs)
    Local local0%
    Local local1%
    Local local2$
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7%
    Local local8#
    Local local9%
    If (arg0\Field51 <> 0) Then
        local2 = getnpcmanipulationvalue(arg0\Field57, arg0\Field53, "bonename", $00)
        If (local2 <> "") Then
            local1 = createpivot($00)
            local0 = findchild(arg0\Field0, local2)
            If (local0 = $00) Then
                freeentity(local1)
                Return $00
            EndIf
            positionentity(local1, entityx(local0, $01), entityy(local0, $01), entityz(local0, $01), $00)
            local9 = arg0\Field52
            If (local9 = $00) Then
                For local7 = $01 To (Int getnpcmanipulationvalue(arg0\Field57, arg0\Field53, "controller_max", $01)) Step $01
                    If (getnpcmanipulationvalue(arg0\Field57, arg0\Field53, ("controlleraxis" + (Str local7)), $00) = "pitch") Then
                        local3 = (Float getnpcmanipulationvalue(arg0\Field57, arg0\Field53, (("controlleraxis" + (Str local7)) + "_max"), $02))
                        local4 = (Float getnpcmanipulationvalue(arg0\Field57, arg0\Field53, (("controlleraxis" + (Str local7)) + "_min"), $02))
                        local5 = (Float getnpcmanipulationvalue(arg0\Field57, arg0\Field53, (("controlleraxis" + (Str local7)) + "_offset"), $02))
                        If ((Int getnpcmanipulationvalue(arg0\Field57, arg0\Field53, (("controlleraxis" + (Str local7)) + "_inverse"), $03)) <> 0) Then
                            local8 = ((- deltapitch(local0, getplayerhead(arg0\Field74))) + local5)
                        Else
                            local8 = (deltapitch(local0, getplayerhead(arg0\Field74)) + local5)
                        EndIf
                        local6 = (Float getnpcmanipulationvalue(arg0\Field57, arg0\Field53, (("controlleraxis" + (Str local7)) + "_smoothing"), $02))
                        If (0.0 < local6) Then
                            arg0\Field54 = curveangle(local8, arg0\Field54, local6)
                        Else
                            arg0\Field54 = local8
                        EndIf
                        arg0\Field54 = (Float changeanglevalueforcorrectboneassigning(arg0\Field54))
                        arg0\Field54 = max(min(arg0\Field54, local3), local4)
                    ElseIf (getnpcmanipulationvalue(arg0\Field57, arg0\Field53, "controlleraxis1", $00) = "yaw") Then
                        local3 = (Float getnpcmanipulationvalue(arg0\Field57, arg0\Field53, (("controlleraxis" + (Str local7)) + "_max"), $02))
                        local4 = (Float getnpcmanipulationvalue(arg0\Field57, arg0\Field53, (("controlleraxis" + (Str local7)) + "_min"), $02))
                        local5 = (Float getnpcmanipulationvalue(arg0\Field57, arg0\Field53, (("controlleraxis" + (Str local7)) + "_offset"), $02))
                        If ((Int getnpcmanipulationvalue(arg0\Field57, arg0\Field53, (("controlleraxis" + (Str local7)) + "_inverse"), $03)) <> 0) Then
                            local8 = ((- deltayaw(local0, getplayerhead(arg0\Field74))) + local5)
                        Else
                            local8 = (deltayaw(local0, getplayerhead(arg0\Field74)) + local5)
                        EndIf
                        local6 = (Float getnpcmanipulationvalue(arg0\Field57, arg0\Field53, (("controlleraxis" + (Str local7)) + "_smoothing"), $02))
                        If (0.0 < local6) Then
                            arg0\Field55 = curveangle(local8, arg0\Field55, local6)
                        Else
                            arg0\Field55 = local8
                        EndIf
                        arg0\Field55 = (Float changeanglevalueforcorrectboneassigning(arg0\Field55))
                        arg0\Field55 = max(min(arg0\Field55, local3), local4)
                    EndIf
                Next
                rotateentity(local0, (entitypitch(local0, $00) + arg0\Field54), (entityyaw(local0, $00) + arg0\Field55), (entityroll(local0, $00) + arg0\Field56), $00)
            EndIf
            freeentity(local1)
        EndIf
    EndIf
    Return $00
End Function
