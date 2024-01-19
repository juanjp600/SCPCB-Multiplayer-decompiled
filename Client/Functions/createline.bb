Function createline%(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#, arg6%)
    Local local0%
    Local local1%
    If (arg6 = $00) Then
        arg6 = createmesh($00)
        entityfx(arg6, $10)
        local0 = createsurface(arg6, $00)
        local1 = $00
        addvertex(local0, arg0, arg1, arg2, 0.0, 0.0, 1.0)
    Else
        local0 = getsurface(arg6, $01)
        local1 = (countvertices(local0) - $01)
    EndIf
    addvertex(local0, ((arg0 + arg3) / 2.0), ((arg1 + arg4) / 2.0), ((arg2 + arg5) / 2.0), 0.0, 0.0, 1.0)
    addvertex(local0, arg3, arg4, arg5, 1.0, 0.0, 1.0)
    addtriangle(local0, local1, (local1 + $02), (local1 + $01))
    Return arg6
    Return $00
End Function
