Function updateredlight%(arg0%, arg1#, arg2#)
    If (arg2 > ((Float millisec) Mod arg1)) Then
        If (entityhidden(arg0) <> 0) Then
            showentity(arg0)
        EndIf
    ElseIf (entityhidden(arg0) = $00) Then
        hideentity(arg0)
    EndIf
    Return $00
End Function
