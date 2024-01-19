Function attachobject%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#, arg6#, arg7%, arg8%)
    If (arg7 = $FFFFFFFF) Then
        If (arg8 > $00) Then
            positionentity(arg0, arg1, arg2, arg3, $01)
            rotateentity(arg0, arg4, arg5, arg6, $01)
            showentity(arg0)
            Return $01
        Else
            hideentity(arg0)
        EndIf
    ElseIf (arg7 = arg8) Then
        positionentity(arg0, arg1, arg2, arg3, $01)
        rotateentity(arg0, arg4, arg5, arg6, $01)
        showentity(arg0)
        Return $01
    Else
        hideentity(arg0)
    EndIf
    Return $00
    Return $00
End Function
