Function updateelevators#(arg0#, arg1.doors, arg2.doors, arg3%, arg4%, arg5%)
    Local local0#
    Local local1#
    Local local2%
    Local local3#
    Local local4#
    Local local5.npcs
    Local local6.items
    Local local7%
    Local local8.players
    Local local9%
    Local local10.rooms
    If (((arg1 = Null) Or (arg2 = Null)) <> 0) Then
        Return 0.0
    EndIf
    arg1\Field23 = $01
    arg2\Field23 = $01
    If (arg1\Field31 <> $01) Then
        arg1\Field32 = arg3
        arg2\Field32 = arg4
        arg1\Field31 = $01
        arg2\Field31 = $02
        arg1\Field30 = arg2
        arg2\Field30 = arg1
        arg1\Field33 = arg1
        arg2\Field33 = arg1
    EndIf
    arg1\Field4 = $01
    arg2\Field4 = $01
    local7 = $00
    If (((arg1\Field5 = $00) And (arg2\Field5 = $00)) <> 0) Then
        arg1\Field4 = $01
        arg2\Field4 = $01
        If (((0.0 = arg1\Field7) And (0.0 = arg2\Field7)) <> 0) Then
            If (0.0 > arg0) Then
                arg0 = (arg0 - fpsfactor)
                If (-500.0 > arg0) Then
                    arg1\Field4 = $01
                    arg2\Field4 = $00
                    arg0 = 0.0
                    For local8 = Each players
                        If (((280.0 * roomscale) + 0.00075) > (Abs (entityx(local8\Field63, $00) - entityx(arg3, $01)))) Then
                            If (((280.0 * roomscale) + 0.00075) > (Abs (entityz(local8\Field63, $00) - entityz(arg3, $01)))) Then
                                If (((280.0 * roomscale) + 0.00075) > (Abs (entityy(local8\Field63, $00) - entityy(arg3, $01)))) Then
                                    If (arg5 = $00) Then
                                        local3 = distance(entityx(local8\Field63, $00), entityz(local8\Field63, $00), entityx(arg3, $01), entityz(arg3, $01))
                                        local4 = point_direction(entityx(local8\Field63, $00), entityz(local8\Field63, $00), entityx(arg3, $01), entityz(arg3, $01))
                                        local4 = ((entityyaw(arg4, $01) + local4) - entityyaw(arg3, $01))
                                        local4 = wrapangle(local4)
                                        local0 = max(min((cos(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        local1 = max(min((sin(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        rotateentity(local8\Field62, entitypitch(local8\Field62, $00), (angledist(entityyaw(local8\Field62, $00), entityyaw(arg3, $01)) + entityyaw(arg4, $01)), entityroll(local8\Field62, $00), $00)
                                    Else
                                        local0 = max(min((entityx(local8\Field63, $00) - entityx(arg3, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        local1 = max(min((entityz(local8\Field63, $00) - entityz(arg3, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                    EndIf
                                    local9 = $00
                                    If (local8\Field67 = "gatea") Then
                                        For local10 = Each rooms
                                            If (local10\Field7\Field10 = "gateaentrance") Then
                                                mp_setplayerroomid(local8, local10)
                                                local9 = $01
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                    setplayerpositionex(local8\Field30, local8\Field32, (entityx(arg4, $01) + local0), (entityy(arg4, $01) + 0.32), (entityz(arg4, $01) + local1))
                                    local8\Field172 = $01
                                EndIf
                            EndIf
                        EndIf
                    Next
                    For local5 = Each npcs
                        If (((280.0 * roomscale) + 0.00075) > (Abs (entityx(local5\Field4, $00) - entityx(arg3, $01)))) Then
                            If (((280.0 * roomscale) + 0.00075) > (Abs (entityz(local5\Field4, $00) - entityz(arg3, $01)))) Then
                                If (((280.0 * roomscale) + 0.00075) > (Abs (entityy(local5\Field4, $00) - entityy(arg3, $01)))) Then
                                    If (arg5 = $00) Then
                                        local3 = distance(entityx(local5\Field4, $01), entityz(local5\Field4, $01), entityx(arg3, $01), entityz(arg3, $01))
                                        local4 = point_direction(entityx(local5\Field4, $01), entityz(local5\Field4, $01), entityx(arg3, $01), entityz(arg3, $01))
                                        local4 = ((entityyaw(arg4, $01) + local4) - entityyaw(arg3, $01))
                                        local4 = wrapangle(local4)
                                        local0 = max(min((cos(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        local1 = max(min((sin(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        rotateentity(local5\Field4, entitypitch(local5\Field4, $01), (angledist(entityyaw(local5\Field4, $01), entityyaw(arg3, $01)) + entityyaw(arg4, $01)), entityroll(local5\Field4, $01), $01)
                                    Else
                                        local0 = max(min((entityx(local5\Field4, $00) - entityx(arg3, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        local1 = max(min((entityz(local5\Field4, $00) - entityz(arg3, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                    EndIf
                                    teleportentity(local5\Field4, (entityx(arg4, $01) + local0), ((entityy(local5\Field4, $00) - entityy(arg3, $01)) + (entityy(arg4, $01) + 0.005)), (entityz(arg4, $01) + local1), local5\Field68, $01, 2.0, $00)
                                    If (local5 = curr173) Then
                                        curr173\Field69 = 10.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    For local6 = Each items
                        If (local6\Field22 < $01) Then
                            If (((280.0 * roomscale) + 0.00075) > (Abs (entityx(local6\Field1, $00) - entityx(arg3, $01)))) Then
                                If (((280.0 * roomscale) + 0.00075) > (Abs (entityz(local6\Field1, $00) - entityz(arg3, $01)))) Then
                                    If (((280.0 * roomscale) + 0.00075) > (Abs (entityy(local6\Field1, $00) - entityy(arg3, $01)))) Then
                                        If (arg5 = $00) Then
                                            local3 = distance(entityx(local6\Field1, $01), entityz(local6\Field1, $01), entityx(arg3, $01), entityz(arg3, $01))
                                            local4 = point_direction(entityx(local6\Field1, $01), entityz(local6\Field1, $01), entityx(arg3, $01), entityz(arg3, $01))
                                            local4 = ((entityyaw(arg4, $01) + local4) - entityyaw(arg3, $01))
                                            local4 = wrapangle(local4)
                                            local0 = max(min((cos(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                            local1 = max(min((sin(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                            rotateentity(local6\Field1, entitypitch(local6\Field1, $01), (angledist(entityyaw(local6\Field1, $01), entityyaw(arg3, $01)) + entityyaw(arg4, $01)), entityroll(local6\Field1, $01), $01)
                                        Else
                                            local0 = max(min((entityx(local6\Field1, $00) - entityx(arg3, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                            local1 = max(min((entityz(local6\Field1, $00) - entityz(arg3, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        EndIf
                                        teleportentity(local6\Field1, (entityx(arg4, $01) + local0), ((entityy(local6\Field1, $00) - entityy(arg3, $01)) + (entityy(arg4, $01) + 0.005)), (entityz(arg4, $01) + local1), 0.01, $01, 2.0, $00)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    arg2\Field5 = $01
                    arg1\Field5 = $00
                    arg1\Field34 = $00
                    arg2\Field34 = $00
                    playsound2(elevatorbeepsfx, camera, arg3, 4.0, 1.0)
                EndIf
            Else
                arg0 = (arg0 + fpsfactor)
                If (500.0 < arg0) Then
                    arg1\Field4 = $00
                    arg2\Field4 = $01
                    arg0 = 0.0
                    For local8 = Each players
                        If (((280.0 * roomscale) + 0.00075) > (Abs (entityx(local8\Field63, $00) - entityx(arg4, $01)))) Then
                            If (((280.0 * roomscale) + 0.00075) > (Abs (entityz(local8\Field63, $00) - entityz(arg4, $01)))) Then
                                If (((280.0 * roomscale) + 0.00075) > (Abs (entityy(local8\Field63, $00) - entityy(arg4, $01)))) Then
                                    If (arg5 = $00) Then
                                        local3 = distance(entityx(local8\Field63, $00), entityz(local8\Field63, $00), entityx(arg4, $01), entityz(arg4, $01))
                                        local4 = point_direction(entityx(local8\Field63, $00), entityz(local8\Field63, $00), entityx(arg4, $01), entityz(arg4, $01))
                                        local4 = ((entityyaw(arg3, $01) + local4) - entityyaw(arg4, $01))
                                        local0 = max(min((cos(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        local1 = max(min((sin(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        rotateentity(local8\Field62, entitypitch(local8\Field62, $00), (angledist(entityyaw(local8\Field62, $00), entityyaw(arg3, $01)) + entityyaw(arg4, $01)), entityroll(local8\Field62, $00), $01)
                                    Else
                                        local0 = max(min((entityx(local8\Field63, $00) - entityx(arg4, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        local1 = max(min((entityz(local8\Field63, $00) - entityz(arg4, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                    EndIf
                                    local9 = $00
                                    If (local8\Field67 = "gatea") Then
                                        For local10 = Each rooms
                                            If (local10\Field7\Field10 = "gateaentrance") Then
                                                mp_setplayerroomid(local8, local10)
                                                local9 = $01
                                                Exit
                                            EndIf
                                        Next
                                    EndIf
                                    setplayerpositionex(local8\Field30, local8\Field32, (entityx(arg3, $01) + local0), (entityy(arg3, $01) + 0.32), (entityz(arg3, $01) + local1))
                                    local8\Field172 = $01
                                EndIf
                            EndIf
                        EndIf
                    Next
                    For local5 = Each npcs
                        If (((280.0 * roomscale) + 0.00075) > (Abs (entityx(local5\Field4, $00) - entityx(arg4, $01)))) Then
                            If (((280.0 * roomscale) + 0.00075) > (Abs (entityz(local5\Field4, $00) - entityz(arg4, $01)))) Then
                                If (((280.0 * roomscale) + 0.00075) > (Abs (entityy(local5\Field4, $00) - entityy(arg4, $01)))) Then
                                    If (arg5 = $00) Then
                                        local3 = distance(entityx(local5\Field4, $01), entityz(local5\Field4, $01), entityx(arg4, $01), entityz(arg4, $01))
                                        local4 = point_direction(entityx(local5\Field4, $01), entityz(local5\Field4, $01), entityx(arg4, $01), entityz(arg4, $01))
                                        local4 = ((entityyaw(arg3, $01) + local4) - entityyaw(arg4, $01))
                                        local0 = max(min((cos(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        local1 = max(min((sin(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        rotateentity(local5\Field4, entitypitch(local5\Field4, $01), (angledist(entityyaw(local5\Field4, $01), entityyaw(arg3, $01)) + entityyaw(arg4, $01)), entityroll(local5\Field4, $01), $01)
                                    Else
                                        local0 = max(min((entityx(local5\Field4, $00) - entityx(arg4, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        local1 = max(min((entityz(local5\Field4, $00) - entityz(arg4, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                    EndIf
                                    teleportentity(local5\Field4, (entityx(arg3, $01) + local0), ((entityy(local5\Field4, $00) - entityy(arg4, $01)) + (entityy(arg3, $01) + 0.005)), (entityz(arg3, $01) + local1), local5\Field68, $01, 2.0, $00)
                                    If (local5 = curr173) Then
                                        curr173\Field69 = 10.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    For local6 = Each items
                        If (local6\Field22 < $01) Then
                            If (((280.0 * roomscale) + 0.00075) > (Abs (entityx(local6\Field1, $00) - entityx(arg4, $01)))) Then
                                If (((280.0 * roomscale) + 0.00075) > (Abs (entityz(local6\Field1, $00) - entityz(arg4, $01)))) Then
                                    If (((280.0 * roomscale) + 0.00075) > (Abs (entityy(local6\Field1, $00) - entityy(arg4, $01)))) Then
                                        If (arg5 = $00) Then
                                            local3 = distance(entityx(local6\Field1, $01), entityz(local6\Field1, $01), entityx(arg4, $01), entityz(arg4, $01))
                                            local4 = point_direction(entityx(local6\Field1, $01), entityz(local6\Field1, $01), entityx(arg4, $01), entityz(arg4, $01))
                                            local4 = ((entityyaw(arg3, $01) + local4) - entityyaw(arg4, $01))
                                            local0 = max(min((cos(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                            local1 = max(min((sin(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                            rotateentity(local6\Field1, entitypitch(local6\Field1, $01), (angledist(entityyaw(local6\Field1, $01), entityyaw(arg3, $01)) + entityyaw(arg4, $01)), entityroll(local6\Field1, $01), $01)
                                        Else
                                            local0 = max(min((entityx(local6\Field1, $00) - entityx(arg4, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                            local1 = max(min((entityz(local6\Field1, $00) - entityz(arg4, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                        EndIf
                                        teleportentity(local6\Field1, (entityx(arg3, $01) + local0), ((entityy(local6\Field1, $00) - entityy(arg4, $01)) + (entityy(arg3, $01) + 0.005)), (entityz(arg3, $01) + local1), 0.01, $01, 2.0, $00)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    arg1\Field5 = $01
                    arg2\Field5 = $00
                    arg1\Field34 = $00
                    arg2\Field34 = $00
                    playsound2(elevatorbeepsfx, camera, arg4, 4.0, 1.0)
                EndIf
            EndIf
        EndIf
    EndIf
    Return arg0
    Return 0.0
End Function
