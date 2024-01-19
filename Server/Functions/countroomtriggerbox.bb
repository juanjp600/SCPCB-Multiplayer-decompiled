Function countroomtriggerbox%(arg0.rooms)
    Local local0%
    For local0 = $00 To (arg0\Field38 - $01) Step $01
        arg0\Field47[local0] = entityscalex(arg0\Field39[local0], $01)
        arg0\Field48[local0] = max(entityscaley(arg0\Field39[local0], $01), 0.001)
        arg0\Field49[local0] = entityscalez(arg0\Field39[local0], $01)
        getmeshextents(arg0\Field39[local0])
        arg0\Field41[local0] = mesh_minx
        arg0\Field42[local0] = mesh_miny
        arg0\Field43[local0] = mesh_minz
        arg0\Field44[local0] = mesh_maxx
        arg0\Field45[local0] = mesh_maxy
        arg0\Field46[local0] = mesh_maxz
    Next
    Return $00
End Function
