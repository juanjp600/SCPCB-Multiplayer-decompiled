Function finishwalking%(arg0.npcs, arg1#, arg2#, arg3#)
    Local local0#
    If (arg0 <> Null) Then
        local0 = ((arg2 - arg1) / 2.0)
        If (local0 <= arg0\Field14) Then
            animatenpc(arg0, arg1, arg2, arg3, $00)
        Else
            animatenpc(arg0, arg2, arg1, (- arg3), $00)
        EndIf
    EndIf
    Return $00
End Function
