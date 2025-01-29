Function mp_updatenpcobject%(arg0.npcs)
    If (((arg0\Field97 = $00) And (mp_ishoster() = $00)) <> 0) Then
        arg0\Field92 = curveangle(arg0\Field78, arg0\Field92, 4.0)
        arg0\Field91 = curveangle(arg0\Field77, arg0\Field91, 4.0)
        rotateentity(arg0\Field3, entitypitch(arg0\Field3, $01), arg0\Field91, entityroll(arg0\Field3, $01), $01)
        rotateentity(arg0\Field0, entitypitch(arg0\Field0, $01), arg0\Field92, entityroll(arg0\Field0, $01), $01)
        If (0.0 < arg0\Field79) Then
            arg0\Field82 = mp_animateex(arg0\Field0, arg0\Field82, (Int arg0\Field86), (Int arg0\Field87), arg0\Field88, arg0\Field89)
            mp_setnpcframe(arg0, arg0\Field82)
            If (((0.0 >= arg0\Field83) And (isequal(arg0\Field82, arg0\Field14, 3.0) = $00)) <> 0) Then
                arg0\Field14 = arg0\Field82
                arg0\Field83 = 70.0
            EndIf
            arg0\Field83 = (arg0\Field83 - fps\Field7[$00])
            If (isequal(arg0\Field79, arg0\Field80, 0.1) <> 0) Then
                arg0\Field81 = (arg0\Field81 + fps\Field7[$00])
                If (70.0 <= arg0\Field81) Then
                    setanimtime(arg0\Field0, arg0\Field79, $00)
                    arg0\Field82 = arg0\Field79
                    arg0\Field14 = arg0\Field79
                EndIf
            Else
                arg0\Field81 = 0.0
            EndIf
            arg0\Field80 = arg0\Field79
        EndIf
    EndIf
    Return $00
End Function
