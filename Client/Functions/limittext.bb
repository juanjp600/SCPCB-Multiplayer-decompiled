Function limittext%(arg0$, arg1%, arg2%, arg3%, arg4%, arg5%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    If (arg4 <> 0) Then
        If (((arg0 = "") Or (arg3 = $00)) <> 0) Then
            Return $00
        EndIf
        local0 = stringwidth(arg0)
        local1 = (local0 - arg3)
        If (local1 <= $00) Then
            If (arg5 <> 0) Then
                local3 = colorredex()
                local4 = colorgreenex()
                local5 = colorblueex()
                setcolorex($00, $00, $00)
                text((arg1 + $01), (arg2 + $01), arg0, $00, $00)
                setcolorex(local3, local4, local5)
            EndIf
            text(arg1, arg2, arg0, $00, $00)
        Else
            local2 = (local0 / len(arg0))
            If (arg5 <> 0) Then
                local3 = colorredex()
                local4 = colorgreenex()
                local5 = colorblueex()
                setcolorex($00, $00, $00)
                text((arg1 + $01), (arg2 + $01), (left(arg0, (Int max((Float ((len(arg0) - (local1 / local2)) - $04)), 1.0))) + "..."), $00, $00)
                setcolorex(local3, local4, local5)
            EndIf
            text(arg1, arg2, (left(arg0, (Int max((Float ((len(arg0) - (local1 / local2)) - $04)), 1.0))) + "..."), $00, $00)
        EndIf
    Else
        If (((arg0 = "") Or (arg3 = $00)) <> 0) Then
            Return $00
        EndIf
        local0 = stringwidth(arg0)
        local1 = (local0 - arg3)
        If (local1 <= $00) Then
            If (arg5 <> 0) Then
                local3 = colorredex()
                local4 = colorgreenex()
                local5 = colorblueex()
                setcolorex($00, $00, $00)
                text((arg1 + $01), (arg2 + $01), arg0, $00, $00)
                setcolorex(local3, local4, local5)
            EndIf
            text(arg1, arg2, arg0, $00, $00)
        Else
            local2 = (local0 / len(arg0))
            If (arg5 <> 0) Then
                local3 = colorredex()
                local4 = colorgreenex()
                local5 = colorblueex()
                setcolorex($00, $00, $00)
                text((arg1 + $01), (arg2 + $01), (left(arg0, (Int max((Float ((len(arg0) - (local1 / local2)) - $04)), 1.0))) + "..."), $00, $00)
                setcolorex(local3, local4, local5)
            EndIf
            text(arg1, arg2, (left(arg0, (Int max((Float ((len(arg0) - (local1 / local2)) - $04)), 1.0))) + "..."), $00, $00)
        EndIf
    EndIf
    Return $00
End Function
