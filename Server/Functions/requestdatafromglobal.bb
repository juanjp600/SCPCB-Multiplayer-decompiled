Function requestdatafromglobal%()
    Local local0%
    Local local1.steaminstances
    Local local2%
    Local local3$
    Local local4%
    Local local5%
    Local local6%
    Return $00
    local0 = downloadfile("https://raw.githubusercontent.com/FusionCreators/CentralServer-ListFetch/refs/heads/main/SteamTags.txt", "Data\steamtags.txt")
    local0 = openfile("Data\steamtags.txt")
    For local1 = Each steaminstances
        If (local1\Field5 <> 0) Then
            Delete local1
        EndIf
    Next
    While (eof(local0) = $00)
        If (readline(local0) = "ContainTag") Then
            local2 = (Int readline(local0))
            local3 = readline(local0)
            local4 = (Int readline(local0))
            local5 = (Int readline(local0))
            local6 = (Int readline(local0))
            createsteaminstance(local2, local3, local4, local5, local6, $01)
        EndIf
    Wend
    closefile(local0)
    Return $00
End Function
