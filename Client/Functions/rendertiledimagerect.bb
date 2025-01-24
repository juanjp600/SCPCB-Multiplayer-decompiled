Function rendertiledimagerect%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5%, arg6%, arg7%, arg8%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    local2 = arg5
    While (local2 < (arg5 + arg7))
        local0 = arg3
        If ((local2 + arg3) > (arg5 + arg7)) Then
            local0 = ((arg5 + arg7) - local2)
        EndIf
        local3 = arg6
        While (local3 < (arg6 + arg8))
            local1 = arg4
            If ((local3 + arg4) > (arg6 + arg8)) Then
                local1 = ((arg6 + arg8) - local3)
            EndIf
            drawblockrect(arg0, local2, local3, arg1, arg2, local0, local1, $00)
            local3 = (local3 + local1)
        Wend
        local2 = (local2 + local0)
    Wend
    Return $00
End Function
