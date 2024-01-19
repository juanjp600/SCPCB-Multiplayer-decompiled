Function update096elevatorevent#(arg0.events, arg1#, arg2.doors, arg3%)
    Local local0#
    local0 = arg1
    If (0.0 > arg1) Then
        arg1 = 0.0
        local0 = 0.0
    EndIf
    If (((0.0 = arg2\Field7) And (arg2\Field5 = $00)) <> 0) Then
        If (((280.0 * roomscale) + (0.015 * fpsfactor)) >= (Abs (entityx(arg0\Field13, $00) - entityx(arg3, $01)))) Then
            If (((280.0 * roomscale) + (0.015 * fpsfactor)) >= (Abs (entityz(arg0\Field13, $00) - entityz(arg3, $01)))) Then
                If (((280.0 * roomscale) + (0.015 * fpsfactor)) >= (Abs (entityy(arg0\Field13, $00) - entityy(arg3, $01)))) Then
                    arg2\Field4 = $01
                    If (0.0 = arg1) Then
                        teleportentity(curr096\Field4, entityx(arg2\Field2, $00), (entityy(arg2\Field2, $00) + 1.0), entityz(arg2\Field2, $00), curr096\Field68, $00, 2.0, $00)
                        pointentity(curr096\Field4, arg3, 0.0)
                        rotateentity(curr096\Field4, 0.0, entityyaw(curr096\Field4, $00), 0.0, $00)
                        moveentity(curr096\Field4, 0.0, 0.0, -0.5)
                        resetentity(curr096\Field4)
                        curr096\Field9 = 6.0
                        setnpcframe(curr096, 0.0)
                        arg0\Field7 = loadsound_strict("SFX\SCP\096\ElevatorSlam.ogg")
                        arg1 = ((fpsfactor * 1.4) + arg1)
                    EndIf
                EndIf
            EndIf
        EndIf
    EndIf
    If (0.0 < arg1) Then
        If (0.0 = local0) Then
            arg0\Field5 = playsound_strict(arg0\Field7)
        EndIf
        If (((133.0 < arg1) And (arg1 < (140.0 + fpsfactor))) <> 0) Then
            camerashake = 7.0
        ElseIf (((294.0 < arg1) And (arg1 < (297.5 + fpsfactor))) <> 0) Then
            camerashake = 1.0
        ElseIf (((413.0 < arg1) And (arg1 < (416.5 + fpsfactor))) <> 0) Then
            camerashake = 1.0
        ElseIf (((507.5 < arg1) And (arg1 < (511.0 + fpsfactor))) <> 0) Then
            camerashake = 1.0
            arg2\Field8 = $01
            arg2\Field5 = $01
            curr096\Field9 = 4.0
            curr096\Field26 = $01
        ElseIf (((567.0 < arg1) And (arg1 < (570.5 + fpsfactor))) <> 0) Then
            camerashake = 1.0
        EndIf
        If (567.0 >= arg1) Then
            arg2\Field7 = min(arg2\Field7, 20.0)
        EndIf
        arg1 = ((fpsfactor * 1.4) + arg1)
    EndIf
    Return arg1
    Return 0.0
End Function
