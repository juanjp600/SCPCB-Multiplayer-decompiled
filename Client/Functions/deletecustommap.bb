Function deletecustommap%(arg0.custommaps)
    Local local0%
    Local local1$
    local0 = readdir("Map Creator\Maps\")
    If (local0 <> $00) Then
        nextfile(local0)
        nextfile(local0)
        local1 = nextfile(local0)
        While (local1 <> "")
            deletefile(("Map Creator\Maps\" + local1))
            local1 = nextfile(local0)
        Wend
        closedir(local0)
        custommapsamount = (custommapsamount - $01)
    EndIf
    Delete arg0
    Return $00
End Function
