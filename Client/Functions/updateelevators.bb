Function updateelevators#(arg0#, arg1.doors, arg2.doors, arg3%, arg4%, arg5%)
    Local local0#
    Local local1#
    Local local2%
    Local local3#
    Local local4#
    Local local5.npcs
    Local local6.items
    Local local7%
    Local local8.rooms
    If (((arg1 = Null) Or (arg2 = Null)) <> 0) Then
        Return 0.0
    EndIf
    If (arg1\Field37 <> $01) Then
        arg1\Field37 = $01
        arg2\Field37 = $02
        arg1\Field36 = arg2
        arg2\Field36 = arg1
    EndIf
    arg1\Field23 = $01
    arg2\Field23 = $01
    If ((((arg1\Field5 = $01) And (arg2\Field5 = $00)) And (180.0 = arg1\Field7)) <> 0) Then
        arg0 = -1.0
        arg1\Field4 = $00
        If ((((closestbutton = arg2\Field3[$00]) Or (closestbutton = arg2\Field3[$01])) And ismouseup()) <> 0) Then
            usedoor(arg1, $01, $01, $01, "", $00)
            mouseup1 = $00
        EndIf
    ElseIf ((((arg2\Field5 = $01) And (arg1\Field5 = $00)) And (180.0 = arg2\Field7)) <> 0) Then
        arg0 = 1.0
        arg2\Field4 = $00
        If ((((closestbutton = arg1\Field3[$00]) Or (closestbutton = arg1\Field3[$01])) And ismouseup()) <> 0) Then
            usedoor(arg2, $01, $01, $01, "", $00)
            mouseup1 = $00
        EndIf
    ElseIf (0.2 > (Abs (arg1\Field7 - arg2\Field7))) Then
        arg1\Field23 = $02
        arg2\Field23 = $02
    EndIf
    arg1\Field4 = $01
    arg2\Field4 = $01
    If (arg1\Field5 <> 0) Then
        arg1\Field23 = $03
        If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityx(collider, $00) - entityx(arg3, $01)))) Then
            If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityz(collider, $00) - entityz(arg3, $01)))) Then
                If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityy(collider, $00) - entityy(arg3, $01)))) Then
                    arg1\Field4 = $00
                    arg1\Field23 = $01
                EndIf
            EndIf
        EndIf
    EndIf
    If (arg2\Field5 <> 0) Then
        arg2\Field23 = $03
        If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityx(collider, $00) - entityx(arg4, $01)))) Then
            If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityz(collider, $00) - entityz(arg4, $01)))) Then
                If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityy(collider, $00) - entityy(arg4, $01)))) Then
                    arg2\Field4 = $00
                    arg2\Field23 = $01
                EndIf
            EndIf
        EndIf
    EndIf
    local7 = $00
    If (((arg1\Field5 = $00) And (arg2\Field5 = $00)) <> 0) Then
        arg1\Field4 = $01
        arg2\Field4 = $01
        If (((0.0 = arg1\Field7) And (0.0 = arg2\Field7)) <> 0) Then
            If (0.0 > arg0) Then
                arg0 = (arg0 - fpsfactor)
                If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityx(collider, $00) - entityx(arg3, $01)))) Then
                    If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityz(collider, $00) - entityz(arg3, $01)))) Then
                        If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityy(collider, $00) - entityy(arg3, $01)))) Then
                            local7 = $01
                            If (arg1\Field27 = $00) Then
                                arg1\Field27 = playsound_strict(elevatormovesfx)
                            ElseIf (channelplaying(arg1\Field27) = $00) Then
                                arg1\Field27 = playsound_strict(elevatormovesfx)
                            EndIf
                            camerashake = (sin(((Abs arg0) / 3.0)) * 0.3)
                            jumpstate = -1.0
                        EndIf
                    EndIf
                EndIf
                If (-500.0 > arg0) Then
                    arg1\Field4 = $01
                    arg2\Field4 = $00
                    arg0 = 0.0
                    If (local7 <> 0) Then
                        If (networkserver\Field65 = $00) Then
                            If (arg5 = $00) Then
                                local3 = distance(entityx(collider, $01), entityz(collider, $01), entityx(arg3, $01), entityz(arg3, $01))
                                local4 = point_direction(entityx(collider, $01), entityz(collider, $01), entityx(arg3, $01), entityz(arg3, $01))
                                local4 = ((entityyaw(arg4, $01) + local4) - entityyaw(arg3, $01))
                                local4 = wrapangle(local4)
                                local0 = max(min((cos(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                local1 = max(min((sin(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                rotateentity(collider, entitypitch(collider, $01), (angledist(entityyaw(collider, $01), entityyaw(arg3, $01)) + entityyaw(arg4, $01)), entityroll(collider, $01), $01)
                            Else
                                local0 = max(min((entityx(collider, $00) - entityx(arg3, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                local1 = max(min((entityz(collider, $00) - entityz(arg3, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                            EndIf
                            teleportentity(collider, (entityx(arg4, $01) + local0), (((0.1 * fpsfactor) + entityy(arg4, $01)) + (entityy(collider, $00) - entityy(arg3, $01))), (entityz(arg4, $01) + local1), 0.3, $01, 2.0, $00)
                            If (playerroom\Field7\Field11 = "gatea") Then
                                For local8 = Each rooms
                                    If (local8\Field7\Field11 = "gateaentrance") Then
                                        positionentity(collider, entityx(collider, $00), (entityy(collider, $00) + 1.0), entityz(collider, $00), $00)
                                        resetentity(collider)
                                        playerroom = local8
                                        Exit
                                    EndIf
                                Next
                            EndIf
                            updatedoorstimer = 0.0
                            dropspeed = 0.0
                            updatedoors()
                            updaterooms()
                        EndIf
                        local2 = rand($00, $02)
                        arg2\Field16 = playsound_strict(opendoorsfx($03, local2))
                    EndIf
                    For local5 = Each npcs
                        If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityx(local5\Field4, $00) - entityx(arg3, $01)))) Then
                            If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityz(local5\Field4, $00) - entityz(arg3, $01)))) Then
                                If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityy(local5\Field4, $00) - entityy(arg3, $01)))) Then
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
                                    teleportentity(local5\Field4, (entityx(arg4, $01) + local0), (((0.1 * fpsfactor) + entityy(arg4, $01)) + (entityy(local5\Field4, $00) - entityy(arg3, $01))), (entityz(arg4, $01) + local1), local5\Field68, $01, 2.0, $00)
                                    If (local5 = curr173) Then
                                        curr173\Field69 = 10.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    For local6 = Each items
                        If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityx(local6\Field1, $00) - entityx(arg3, $01)))) Then
                            If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityz(local6\Field1, $00) - entityz(arg3, $01)))) Then
                                If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityy(local6\Field1, $00) - entityy(arg3, $01)))) Then
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
                                    teleportentity(local6\Field1, (entityx(arg4, $01) + local0), (((0.1 * fpsfactor) + entityy(arg4, $01)) + (entityy(local6\Field1, $00) - entityy(arg3, $01))), (entityz(arg4, $01) + local1), 0.01, $01, 2.0, $00)
                                EndIf
                            EndIf
                        EndIf
                    Next
                    usedoor(arg2, $00, (local7 = $00), $00, "", $00)
                    arg1\Field5 = $00
                    playsound2(elevatorbeepsfx, camera, arg3, 4.0, 1.0)
                    If (networkserver\Field65 = $00) Then
                        arg2\Field35 = $00
                        arg1\Field35 = $00
                    EndIf
                EndIf
            Else
                arg0 = (arg0 + fpsfactor)
                If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityx(collider, $00) - entityx(arg4, $01)))) Then
                    If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityz(collider, $00) - entityz(arg4, $01)))) Then
                        If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityy(collider, $00) - entityy(arg4, $01)))) Then
                            local7 = $01
                            If (arg1\Field27 = $00) Then
                                arg1\Field27 = playsound_strict(elevatormovesfx)
                            ElseIf (channelplaying(arg1\Field27) = $00) Then
                                arg1\Field27 = playsound_strict(elevatormovesfx)
                            EndIf
                            camerashake = (sin(((Abs arg0) / 3.0)) * 0.3)
                            jumpstate = -1.0
                        EndIf
                    EndIf
                EndIf
                If (500.0 < arg0) Then
                    arg1\Field4 = $00
                    arg2\Field4 = $01
                    arg0 = 0.0
                    If (local7 <> 0) Then
                        If (networkserver\Field65 = $00) Then
                            If (arg5 = $00) Then
                                local3 = distance(entityx(collider, $01), entityz(collider, $01), entityx(arg4, $01), entityz(arg4, $01))
                                local4 = point_direction(entityx(collider, $01), entityz(collider, $01), entityx(arg4, $01), entityz(arg4, $01))
                                local4 = ((entityyaw(arg3, $01) + local4) - entityyaw(arg4, $01))
                                local0 = max(min((cos(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                local1 = max(min((sin(local4) * local3), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                rotateentity(collider, entitypitch(collider, $01), (angledist(entityyaw(collider, $01), entityyaw(arg3, $01)) + entityyaw(arg4, $01)), entityroll(collider, $01), $01)
                            Else
                                local0 = max(min((entityx(collider, $00) - entityx(arg4, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                                local1 = max(min((entityz(collider, $00) - entityz(arg4, $01)), ((280.0 * roomscale) - 0.22)), ((-280.0 * roomscale) + 0.22))
                            EndIf
                            teleportentity(collider, (entityx(arg3, $01) + local0), (((0.1 * fpsfactor) + entityy(arg3, $01)) + (entityy(collider, $00) - entityy(arg4, $01))), (entityz(arg3, $01) + local1), 0.3, $01, 2.0, $00)
                            If (playerroom\Field7\Field11 = "gatea") Then
                                For local8 = Each rooms
                                    If (local8\Field7\Field11 = "gateaentrance") Then
                                        positionentity(collider, entityx(collider, $00), (entityy(collider, $00) + 1.0), entityz(collider, $00), $00)
                                        resetentity(collider)
                                        playerroom = local8
                                        Exit
                                    EndIf
                                Next
                            EndIf
                            updatedoorstimer = 0.0
                            dropspeed = 0.0
                            updatedoors()
                            updaterooms()
                        EndIf
                        local2 = rand($00, $02)
                        arg1\Field16 = playsound_strict(opendoorsfx($03, local2))
                    EndIf
                    For local5 = Each npcs
                        If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityx(local5\Field4, $00) - entityx(arg4, $01)))) Then
                            If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityz(local5\Field4, $00) - entityz(arg4, $01)))) Then
                                If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityy(local5\Field4, $00) - entityy(arg4, $01)))) Then
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
                                    teleportentity(local5\Field4, (entityx(arg3, $01) + local0), (((0.1 * fpsfactor) + entityy(arg3, $01)) + (entityy(local5\Field4, $00) - entityy(arg4, $01))), (entityz(arg3, $01) + local1), local5\Field68, $01, 2.0, $00)
                                    If (local5 = curr173) Then
                                        curr173\Field69 = 10.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    For local6 = Each items
                        If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityx(local6\Field1, $00) - entityx(arg4, $01)))) Then
                            If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityz(local6\Field1, $00) - entityz(arg4, $01)))) Then
                                If (((280.0 * roomscale) + (0.015 * fpsfactor)) > (Abs (entityy(local6\Field1, $00) - entityy(arg4, $01)))) Then
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
                                    teleportentity(local6\Field1, (entityx(arg3, $01) + local0), (((0.1 * fpsfactor) + entityy(arg3, $01)) + (entityy(local6\Field1, $00) - entityy(arg4, $01))), (entityz(arg3, $01) + local1), 0.01, $01, 2.0, $00)
                                EndIf
                            EndIf
                        EndIf
                    Next
                    usedoor(arg1, $00, (local7 = $00), $00, "", $00)
                    arg2\Field5 = $00
                    playsound2(elevatorbeepsfx, camera, arg4, 4.0, 1.0)
                    If (networkserver\Field65 = $00) Then
                        arg2\Field35 = $00
                        arg1\Field35 = $00
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    Return arg0
    Return 0.0
End Function
