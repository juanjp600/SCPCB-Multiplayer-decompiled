Function mp_updatenpcobject%(arg0.npcs)
    If (((arg0\Field95 = $00) And (mp_ishoster() = $00)) <> 0) Then
        arg0\Field90 = curveangle(arg0\Field76, arg0\Field90, 4.0)
        arg0\Field89 = curveangle(arg0\Field75, arg0\Field89, 4.0)
        rotateentity(arg0\Field3, entitypitch(arg0\Field3, $01), arg0\Field89, entityroll(arg0\Field3, $01), $01)
        rotateentity(arg0\Field0, entitypitch(arg0\Field0, $01), arg0\Field90, entityroll(arg0\Field0, $01), $01)
        If (0.0 < arg0\Field77) Then
            arg0\Field80 = mp_animateex(arg0\Field0, arg0\Field80, (Int arg0\Field84), (Int arg0\Field85), arg0\Field86, arg0\Field87)
            mp_setnpcframe(arg0, arg0\Field80)
            If (((0.0 >= arg0\Field81) And (isequal(arg0\Field80, arg0\Field14, 3.0) = $00)) <> 0) Then
                arg0\Field14 = arg0\Field80
                arg0\Field81 = 70.0
            EndIf
            arg0\Field81 = (arg0\Field81 - fps\Field7[$00])
            If (isequal(arg0\Field77, arg0\Field78, 0.1) <> 0) Then
                arg0\Field79 = (arg0\Field79 + fps\Field7[$00])
                If (70.0 <= arg0\Field79) Then
                    setanimtime(arg0\Field0, arg0\Field77, $00)
                    arg0\Field80 = arg0\Field77
                    arg0\Field14 = arg0\Field77
                EndIf
            Else
                arg0\Field79 = 0.0
            EndIf
            arg0\Field78 = arg0\Field77
        EndIf
    EndIf
    Return $00
End Function
