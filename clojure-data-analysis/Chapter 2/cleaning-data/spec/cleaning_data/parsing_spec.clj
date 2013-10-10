
(ns cleaning-data.parsing-spec
  (:use [speclj.core]
        [cleaning-data.parsing]))

(def fasta-strs
  [[">SEQUENCE_1
MTEITAAMVKELRESTGAGMMDCKNALSETNGDFDKAVQLLREKGLGKAAKKADRLAAEG
LVSVKVSDDFTIAAMRPSYLSYEDLDMTFVENEYKALVAELEKENEERRRLKDPNKPEHK
IPQFASRKQLSDAILKEAEEKIKEELKAQGKPEKIWDNIIPGKMNSFIADNSQLDSKLTL
MGQFYVMDDKKTVEQVIAEKEKEFGGKIKIVEFICFEVGEGLEKKTEDFAAEVAAQL
>SEQUENCE_2
SATVSEINSETDFVAKNDQFIALTKDTTAHIQSNSLQSVEELHSSTINGVKFEEYLKSQI
ATIGENLVVRRFATLKAGANGVVNGYIHTNGRVGVVIAAACDSAEVASKSRDLLRQICMH"
    [{:defline "SEQUENCE_1"
      :gene-seq "MTEITAAMVKELRESTGAGMMDCKNALSETNGDFDKAVQLLREKGLGKAAKKADRLAAEGLVSVKVSDDFTIAAMRPSYLSYEDLDMTFVENEYKALVAELEKENEERRRLKDPNKPEHKIPQFASRKQLSDAILKEAEEKIKEELKAQGKPEKIWDNIIPGKMNSFIADNSQLDSKLTLMGQFYVMDDKKTVEQVIAEKEKEFGGKIKIVEFICFEVGEGLEKKTEDFAAEVAAQL"}
     {:defline "SEQUENCE_2"
      :gene-seq "SATVSEINSETDFVAKNDQFIALTKDTTAHIQSNSLQSVEELHSSTINGVKFEEYLKSQIATIGENLVVRRFATLKAGANGVVNGYIHTNGRVGVVIAAACDSAEVASKSRDLLRQICMH"}]]
   [">gi|5524211|gb|AAD44166.1| cytochrome b [Elephas maximus maximus]
LCLYTHIGRNIYYGSYLYSETWNTGIMLLLITMATAFMGYVLPWGQMSFWGATVITNLFSAIPYIGTNLV
EWIWGGFSVDKATLNRFFAFHFILPFTMVALAGVHLTFLHETGSNNPLGLTSDSDKIPFHPYYTIKDFLG
LLILILLLLLLALLSPDMLGDPDNHMPADPLNTPLHIKPEWYFLFAYAILRSVPNKLGGVLALFLSIVIL
GLMPFLHTSKHRSMMLRPLSQALFWTLTMDLLTLTWIGSQPVEYPYTIIGQMASILYFSIILAFLPIAGX
IENY"
    [{:defline "gi|5524211|gb|AAD44166.1| cytochrome b [Elephas maximus maximus]"
      :gene-seq "LCLYTHIGRNIYYGSYLYSETWNTGIMLLLITMATAFMGYVLPWGQMSFWGATVITNLFSAIPYIGTNLVEWIWGGFSVDKATLNRFFAFHFILPFTMVALAGVHLTFLHETGSNNPLGLTSDSDKIPFHPYYTIKDFLGLLILILLLLLLALLSPDMLGDPDNHMPADPLNTPLHIKPEWYFLFAYAILRSVPNKLGGVLALFLSIVILGLMPFLHTSKHRSMMLRPLSQALFWTLTMDLLTLTWIGSQPVEYPYTIIGQMASILYFSIILAFLPIAGXIENY"}]]
   [">MCHU - Calmodulin - Human, rabbit, bovine, rat, and chicken
ADQLTEEQIAEFKEAFSLFDKDGDGTITTKELGTVMRSLGQNPTEAELQDMINEVDADGNGTID
FPEFLTMMARKMKDTDSEEEIREAFRVFDKDGNGYISAAELRHVMTNLGEKLTDEEVDEMIREA
DIDGDGQVNYEEFVQMMTAK*"
    [{:defline "MCHU - Calmodulin - Human, rabbit, bovine, rat, and chicken"
      :gene-seq "ADQLTEEQIAEFKEAFSLFDKDGDGTITTKELGTVMRSLGQNPTEAELQDMINEVDADGNGTIDFPEFLTMMARKMKDTDSEEEIREAFRVFDKDGNGYISAAELRHVMTNLGEKLTDEEVDEMIREADIDGDGQVNYEEFVQMMTAK*"}]]
   [">gi|129295|sp|P01013|OVAX_CHICK GENE X PROTEIN (OVALBUMIN-RELATED)
QIKDLLVSSSTDLDTTLVLVNAIYFKGMWKTAFNAEDTREMPFHVTKQESKPVQMMCMNNSFNVATLPAE
KMKILELPFASGDLSMLVLLPDEVSDLERIEKTINFEKLTEWTNPNTMEKRRVKVYLPQMKIEEKYNLTS
VLMALGMTDLFIPSANLTGISSAESLKISQAVHGAFMELSEDGIEMAGSTGVIEDIKHSPESEQFRADHP
FLFLIKHNPTNTIVYFGRYWSP"
    [{:defline "gi|129295|sp|P01013|OVAX_CHICK GENE X PROTEIN (OVALBUMIN-RELATED)"
      :gene-seq "QIKDLLVSSSTDLDTTLVLVNAIYFKGMWKTAFNAEDTREMPFHVTKQESKPVQMMCMNNSFNVATLPAEKMKILELPFASGDLSMLVLLPDEVSDLERIEKTINFEKLTEWTNPNTMEKRRVKVYLPQMKIEEKYNLTSVLMALGMTDLFIPSANLTGISSAESLKISQAVHGAFMELSEDGIEMAGSTGVIEDIKHSPESEQFRADHPFLFLIKHNPTNTIVYFGRYWSP"}]]
   [">gi|190014205|emb|CAQ47849.1| putative dihydroxyacid dehydratase [Stenotrophomonas maltophilia K279a]
MPEYRSRTSTAGRNMAGARALWRATGMKDGDFHKPIIAIANSFTQFVPGHVHLKDLGQLVAREIEQVGGV
AKEFNTIAVDDGIAMGHDGMLYSLPSREIIADAVEYMVNAHCADALVCISNCDKITPGMLMAALRLNIPV
VFVSGGPMEAGKTKLSEHKLDLVDAMVVAADDSASDEKVAAFERSACPTCGSCSGMFTANSMNCLTEALG
LSLPGNGTTLATHADREALFRRAGRLIVELCHRWYGGEDPSALPRGIATQAAFANAMTLDIAMGGSTNTI
LHLLAAAQEAEVDFDLTHIDALSRRVPQLCKVAPNTPKYHIEDVHRAGGVFGILGELDRAGLLETTVPTV
HSASLADALERWDVVRSDNDTLHTFFKAGPAGIPTQEAFSQATRWPTLDVDRAEGCIRSLQHAYSLEGGL
AVLRGNLAVDGCVVKTAGVDESIHVFEGPARVYESQDAAVAGILADEVQPGEVVVIRYEGPKGGPGMQEM
LYPTSYLKSKGLGKQCALLTDGRFSGGTSGLSIGHVSPEAASGGVIGLVEDGDRIRIDIPARRIDLLLDE
AVLAQRRSDADARGWKPRAPRPRKVTSALKAYALLATSADKGAVRNTALLGD"
    [{:defline "gi|190014205|emb|CAQ47849.1| putative dihydroxyacid dehydratase [Stenotrophomonas maltophilia K279a]"
      :gene-seq "MPEYRSRTSTAGRNMAGARALWRATGMKDGDFHKPIIAIANSFTQFVPGHVHLKDLGQLVAREIEQVGGVAKEFNTIAVDDGIAMGHDGMLYSLPSREIIADAVEYMVNAHCADALVCISNCDKITPGMLMAALRLNIPVVFVSGGPMEAGKTKLSEHKLDLVDAMVVAADDSASDEKVAAFERSACPTCGSCSGMFTANSMNCLTEALGLSLPGNGTTLATHADREALFRRAGRLIVELCHRWYGGEDPSALPRGIATQAAFANAMTLDIAMGGSTNTILHLLAAAQEAEVDFDLTHIDALSRRVPQLCKVAPNTPKYHIEDVHRAGGVFGILGELDRAGLLETTVPTVHSASLADALERWDVVRSDNDTLHTFFKAGPAGIPTQEAFSQATRWPTLDVDRAEGCIRSLQHAYSLEGGLAVLRGNLAVDGCVVKTAGVDESIHVFEGPARVYESQDAAVAGILADEVQPGEVVVIRYEGPKGGPGMQEMLYPTSYLKSKGLGKQCALLTDGRFSGGTSGLSIGHVSPEAASGGVIGLVEDGDRIRIDIPARRIDLLLDEAVLAQRRSDADARGWKPRAPRPRKVTSALKAYALLATSADKGAVRNTALLGD"}]]
   [">gi|190576272|ref|YP_001974117.1| transferase [Stenotrophomonas maltophilia K279a]
MNPLRPFRDKMPVLGERVYIDPSCTIIGDVELGDDVSVWPGTVIRGDVNYVRIGARTNVQDGTIIHVSHH
SPYNKAGYPTLIGEGVTVGHGCIIHACTIGDYSLIGMGACILDGARVERHGFVGAGAVIGPGKVVGEGEL
WVGNPARPARTLSDKEIESLHYSADHYVQLKDEYRG"
    [{:defline "gi|190576272|ref|YP_001974117.1| transferase [Stenotrophomonas maltophilia K279a]"
      :gene-seq "MNPLRPFRDKMPVLGERVYIDPSCTIIGDVELGDDVSVWPGTVIRGDVNYVRIGARTNVQDGTIIHVSHHSPYNKAGYPTLIGEGVTVGHGCIIHACTIGDYSLIGMGACILDGARVERHGFVGAGAVIGPGKVVGEGELWVGNPARPARTLSDKEIESLHYSADHYVQLKDEYRG"}]]
   [">gi|16759485|ref|NP_455102.1| ABC transporter ATP-binding protein YbbA [Salmonella enterica subsp. enterica serovar Typhi str. CT18]
MPAENSVEVHRLRKSVGQGEHELSILTGVELVVKRGETIALIGESGSGKSTLLAILAGLDDGSSGEVSLV
GKPLHQMDEEARAQLRAQHVGFVFQSFMLIPTLNALENVELPALLRGENSGQSKAGAKALLEQLGLGKRL
DHLPAQLSGGEQQRVALARAFNGRPDVLFADEPTGNLDRQTGDKIADLLFSLNREHGTTLILVTHDPALA
ARCDRRLRLVNGQLQEEA"
    [{:defline "gi|16759485|ref|NP_455102.1| ABC transporter ATP-binding protein YbbA [Salmonella enterica subsp. enterica serovar Typhi str. CT18]"
      :gene-seq "MPAENSVEVHRLRKSVGQGEHELSILTGVELVVKRGETIALIGESGSGKSTLLAILAGLDDGSSGEVSLVGKPLHQMDEEARAQLRAQHVGFVFQSFMLIPTLNALENVELPALLRGENSGQSKAGAKALLEQLGLGKRLDHLPAQLSGGEQQRVALARAFNGRPDVLFADEPTGNLDRQTGDKIADLLFSLNREHGTTLILVTHDPALAARCDRRLRLVNGQLQEEA"}]]
   [">gi|190014208|emb|CAQ47852.1| putative shikimate dehydrogenase [Stenotrophomonas maltophilia K279a]
MTDRYAVFGHPVAHSKSPQIHATFGRQEGIAVDYRAIDLAPEAFLAGLEAFAADGGVGANVTSPHKEAAF
SVCTTLTARARRAGSVNTLLRKGDRWHGDTTDGIGLVRDLTDRHGLDLRGRRMLLIGAGGSARSVAPALL
DAGITELVVVNRTPERADELIDAMGEPGRAISRYWEDLRDLGDFELIVNATSAGRDRDIEFKLPLSLVNS
MTTAVDLNYGEAAIAFLAWARAAECRNTVDGLGMLVEQAAESFLQWHGVRPQTDEVYQSLRQGSAVLAGE
D"
    [{:defline "gi|190014208|emb|CAQ47852.1| putative shikimate dehydrogenase [Stenotrophomonas maltophilia K279a]"
      :gene-seq "MTDRYAVFGHPVAHSKSPQIHATFGRQEGIAVDYRAIDLAPEAFLAGLEAFAADGGVGANVTSPHKEAAFSVCTTLTARARRAGSVNTLLRKGDRWHGDTTDGIGLVRDLTDRHGLDLRGRRMLLIGAGGSARSVAPALLDAGITELVVVNRTPERADELIDAMGEPGRAISRYWEDLRDLGDFELIVNATSAGRDRDIEFKLPLSLVNSMTTAVDLNYGEAAIAFLAWARAAECRNTVDGLGMLVEQAAESFLQWHGVRPQTDEVYQSLRQGSAVLAGED"}]]
   [">gi|190573783|ref|YP_001971628.1| ABC transporter ATP-binding protein [Stenotrophomonas maltophilia K279a]
MNKVFNRGDEVIRAEALGKTYAEGRMQTPVFDGLDLTVTAGETVAIIGASGAGKSTLLHLLGGLDIPTAG
EVYVTGQRMSALSDTARGLLRNQALGFVYQFHHLLPEFTALENVMMPVLLAGTAVAEASSRATTLLEAVG
LGHRLDHKPGELSGGERQRAAVARALVNHPACVLGDEPTGNLDDRTAATVFELMLELNRARHTSLVLVTH
DRSLARRLDRVLELREGRLHALAHADV"
    [{:defline "gi|190573783|ref|YP_001971628.1| ABC transporter ATP-binding protein [Stenotrophomonas maltophilia K279a]"
      :gene-seq "MNKVFNRGDEVIRAEALGKTYAEGRMQTPVFDGLDLTVTAGETVAIIGASGAGKSTLLHLLGGLDIPTAGEVYVTGQRMSALSDTARGLLRNQALGFVYQFHHLLPEFTALENVMMPVLLAGTAVAEASSRATTLLEAVGLGHRLDHKPGELSGGERQRAAVARALVNHPACVLGDEPTGNLDDRTAATVFELMLELNRARHTSLVLVTHDRSLARRLDRVLELREGRLHALAHADV"}]]])

(defn parse-pair
  ([[input expecteds]]
   (let [actuals (parse-fasta input)]
     (reduce #(and %1 %2)
             (= (count expecteds) (count actuals))
             (mapv = expecteds actuals)))))

(describe
  "parse-fasta"
  (it "should parse a multi-fasta."
      (should (parse-pair (first fasta-strs))))
  (it "should parse 'Elephas maximus maximus.'"
      (should (parse-pair (second fasta-strs))))
  (it "should parse 'MCHU - Calmodulin - Human, rabbit, bovine, rat, and chicken.'"
      (should (parse-pair (nth fasta-strs 2))))
  (it "should parse 'gi|129295|sp|P01013|OVAX_CHICK GENE X PROTEIN (OVALBUMIN-RELATED).'"
      (should (parse-pair (nth fasta-strs 3))))
  (it "should parse 'putative dihydroxyacid dehydratase [Stenotrophomonas maltophilia K279a].'"
      (should (parse-pair (nth fasta-strs 4))))
  (it "should parse 'transferase [Stenotrophomonas maltophilia K279a].'"
      (should (parse-pair (nth fasta-strs 5))))
  (it "should parse 'ABC transporter ATP-binding protein YbbA [Salmonella enterica subsp. enterica serovar Typhi str. CT18].'"
      (should (parse-pair (nth fasta-strs 6))))
  (it "should parse 'putative shikimate dehydrogenase [Stenotrophomonas maltophilia K279a].'"
      (should (parse-pair (nth fasta-strs 7))))
  (it "should parse 'ABC transporter ATP-binding protein [Stenotrophomonas maltophilia K279a].'"
      (should (parse-pair (nth fasta-strs 8)))))

(run-specs)


