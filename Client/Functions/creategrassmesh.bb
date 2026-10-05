Function creategrassmesh%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    local0 = createmesh($00)
    local1 = createsurface(local0, $00)
    local2 = addvertex(local1, -0.5, 1.0, -0.5, 0.0, 0.0, 1.0)
    local3 = addvertex(local1, 0.5, 1.0, 0.5, 1.0, 0.0, 1.0)
    local4 = addvertex(local1, 0.5, 0.0, 0.5, 1.0, 1.0, 1.0)
    local5 = addvertex(local1, -0.5, 0.0, -0.5, 0.0, 1.0, 1.0)
    addtriangle(local1, local2, local3, local4)
    addtriangle(local1, local2, local4, local5)
    addtriangle(local1, local4, local3, local2)
    addtriangle(local1, local5, local4, local2)
    local2 = addvertex(local1, -0.5, 1.0, 0.5, 0.0, 0.0, 1.0)
    local3 = addvertex(local1, 0.5, 1.0, -0.5, 1.0, 0.0, 1.0)
    local4 = addvertex(local1, 0.5, 0.0, -0.5, 1.0, 1.0, 1.0)
    local5 = addvertex(local1, -0.5, 0.0, 0.5, 0.0, 1.0, 1.0)
    addtriangle(local1, local2, local3, local4)
    addtriangle(local1, local2, local4, local5)
    addtriangle(local1, local4, local3, local2)
    addtriangle(local1, local5, local4, local2)
    Return local0
    Return $00
End Function
