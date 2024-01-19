Function alupdatesoundvolume%(arg0%, arg1%, arg2%, arg3#, arg4#)
    Local local0#
    local0 = (entitydistance(arg1, arg2) / arg3)
    If (((0.0 < (1.0 - local0)) And (1.0 > (1.0 - local0))) <> 0) Then
        alsourcesetvolume(arg0, ((1.0 - local0) * arg4))
    Else
        alsourcesetvolume(arg0, 0.0)
    EndIf
    Return $00
End Function
