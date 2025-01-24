Function loadmaterials%(arg0$)
    Local local0$
    Local local1.materials
    Local local2$
    Local local3%
    catcherrors((("LoadMaterials(" + arg0) + ")"))
    local1 = Null
    local2 = ""
    local3 = openfile_strict(arg0)
    While (eof(local3) = $00)
        local0 = trim(readline(local3))
        If (left(local0, $01) = "[") Then
            local0 = mid(local0, $02, (len(local0) - $02))
            local1 = (New materials)
            local1\Field0 = lower(local0)
            If (opt\Field2 <> 0) Then
                local2 = inigetstring(arg0, local0, "bump", "", $01)
                If (local2 <> "") Then
                    local1\Field1 = loadtexture_strict(local2, ((opt\Field3 Shl $08) + $01), $00, $00)
                    applybumpmap(local1\Field1)
                EndIf
            EndIf
            local1\Field4 = inigetint(arg0, local0, "stepsound", $00, $01)
            local1\Field2 = inigetint(arg0, local0, "transparent", $00, $01)
            local1\Field3 = inigetint(arg0, local0, "masked", $00, $01)
        EndIf
    Wend
    closefile(local3)
    catcherrors((("Uncaught: LoadMaterials(" + arg0) + ")"))
    Return $00
End Function
