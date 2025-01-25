Function updatelever%(arg0%, arg1%, arg2%, arg3#)
    Local local0#
    Local local1#
    Local local2#
    local1 = entitydistancesquared(camera, arg0)
    If (4.0 > local1) Then
        local2 = entitypitch(arg0, $00)
        If (((0.64 >= local1) And (arg1 = $00)) <> 0) Then
            If (entitypick(camera, 0.8) = arg0) Then
                handentity = arg0
                If ((mo\Field0 Lor mo\Field2) <> 0) Then
                    grabbedentity = arg0
                EndIf
            EndIf
            If (grabbedentity = arg0) Then
                handentity = arg0
                rotateentity(grabbedentity, clamp((clamp((mo\Field8 * 8.0), -30.0, 30.0) + entitypitch(arg0, $00)), arg3, (Float arg2)), entityyaw(arg0, $00), 0.0, $00)
                drawarrowicon[$00] = $01
                drawarrowicon[$02] = $01
            EndIf
        ElseIf (grabbedentity = arg0) Then
            grabbedentity = $00
        EndIf
        If (grabbedentity <> arg0) Then
            If ((((Float arg2) + arg3) / 2.0) < entitypitch(arg0, $01)) Then
                rotateentity(arg0, curvevalue((Float arg2), entitypitch(arg0, $00), 10.0), entityyaw(arg0, $00), 0.0, $00)
            Else
                rotateentity(arg0, curvevalue(arg3, entitypitch(arg0, $00), 10.0), entityyaw(arg0, $00), 0.0, $00)
            EndIf
        EndIf
        local0 = entitypitch(arg0, $01)
        If (local0 > ((Float arg2) - 5.0)) Then
            If (local2 <= ((Float arg2) - 5.0)) Then
                playsoundex(snd_i\Field32, camera, arg0, 2.0, 1.0, $00, $00)
            EndIf
        ElseIf (local0 < (arg3 + 5.0)) Then
            If (local2 >= (arg3 + 5.0)) Then
                playsoundex(snd_i\Field32, camera, arg0, 2.0, 1.0, $00, $00)
            EndIf
        EndIf
    EndIf
    local0 = entitypitch(arg0, $01)
    Return ((local0 > (((Float arg2) + arg3) / 2.0)) = $00)
    Return $00
End Function
