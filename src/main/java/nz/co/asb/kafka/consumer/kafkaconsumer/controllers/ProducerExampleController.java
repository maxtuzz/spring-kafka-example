package nz.co.asb.kafka.consumer.kafkaconsumer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
public class ProducerExampleController {
    private static final Logger logger = LoggerFactory.getLogger(ProducerExampleController.class);

    private final KafkaTemplate<String, String> template;

    @Value("${producer-topic}")
    private String topic;

    @Value("${message-count}")
    private String messageCount;

    @Autowired
    public ProducerExampleController(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    /**
     * Super basic producer example executed through HTTP PUT call i.e. $ curl -XPUT localhost:8080
     *
     * @return Response entity
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> startRandomMessageOnslaught() {
        long startTime = System.nanoTime();

        IntStream.range(0, Integer.parseInt(messageCount)).forEach(i -> template.send(topic, jsonExample));

        long endTime = System.nanoTime();
        double l = (endTime - startTime) / 1000000;
        logger.info("Duration: " + l + " ms");

        // Return status
        return new ResponseEntity<>("Message onslaught finished", HttpStatus.OK);
    }

    /**
     * Hardcoded example JSON for simple message
     */
    private final String jsonExample = "[\n" +
            "  {\n" +
            "    \"_id\": \"5b0b727311de3bf8b4129a00\",\n" +
            "    \"index\": 0,\n" +
            "    \"guid\": \"c9c8a3e8-2e2a-4ba3-8261-54486a56a663\",\n" +
            "    \"isActive\": true,\n" +
            "    \"balance\": \"$1,541.86\",\n" +
            "    \"picture\": \"http://placehold.it/32x32\",\n" +
            "    \"age\": 36,\n" +
            "    \"eyeColor\": \"blue\",\n" +
            "    \"name\": {\n" +
            "      \"first\": \"Brittany\",\n" +
            "      \"last\": \"Giles\"\n" +
            "    },\n" +
            "    \"company\": \"EQUICOM\",\n" +
            "    \"email\": \"brittany.giles@equicom.io\",\n" +
            "    \"phone\": \"+1 (855) 566-2557\",\n" +
            "    \"address\": \"483 Strickland Avenue, Ruckersville, California, 6219\",\n" +
            "    \"about\": \"Sit mollit irure culpa nulla pariatur laborum deserunt laboris deserunt id magna mollit culpa. Culpa eiusmod officia commodo pariatur amet duis Lorem id id anim magna amet tempor ex. Anim in mollit labore consequat et adipisicing eiusmod dolor ex magna sint.\",\n" +
            "    \"registered\": \"Sunday, November 13, 2016 8:43 AM\",\n" +
            "    \"latitude\": \"15.864675\",\n" +
            "    \"longitude\": \"108.733379\",\n" +
            "    \"tags\": [\n" +
            "      \"minim\",\n" +
            "      \"deserunt\",\n" +
            "      \"exercitation\",\n" +
            "      \"deserunt\",\n" +
            "      \"ad\"\n" +
            "    ],\n" +
            "    \"range\": [\n" +
            "      0,\n" +
            "      1,\n" +
            "      2,\n" +
            "      3,\n" +
            "      4,\n" +
            "      5,\n" +
            "      6,\n" +
            "      7,\n" +
            "      8,\n" +
            "      9\n" +
            "    ],\n" +
            "    \"friends\": [\n" +
            "      {\n" +
            "        \"id\": 0,\n" +
            "        \"name\": \"Eddie Bell\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"Fitzpatrick Reynolds\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"name\": \"Katharine Donovan\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"greeting\": \"Hello, Brittany! You have 5 unread messages.\",\n" +
            "    \"favoriteFruit\": \"apple\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"_id\": \"5b0b727308ac0bf41687a613\",\n" +
            "    \"index\": 1,\n" +
            "    \"guid\": \"dde617e7-19cb-4017-a998-dfb158c18e0e\",\n" +
            "    \"isActive\": false,\n" +
            "    \"balance\": \"$3,544.75\",\n" +
            "    \"picture\": \"http://placehold.it/32x32\",\n" +
            "    \"age\": 22,\n" +
            "    \"eyeColor\": \"brown\",\n" +
            "    \"name\": {\n" +
            "      \"first\": \"Trina\",\n" +
            "      \"last\": \"Crawford\"\n" +
            "    },\n" +
            "    \"company\": \"ENERSOL\",\n" +
            "    \"email\": \"trina.crawford@enersol.name\",\n" +
            "    \"phone\": \"+1 (950) 457-3091\",\n" +
            "    \"address\": \"658 Withers Street, Marne, Kansas, 6885\",\n" +
            "    \"about\": \"Sunt velit do ullamco amet velit. Id id irure cillum incididunt. Nulla qui excepteur ipsum aute veniam ad Lorem Lorem. Est amet ut sit in esse consectetur voluptate culpa culpa eu cillum tempor eu tempor. Aute aliquip dolore do sint. Commodo in mollit cupidatat exercitation.\",\n" +
            "    \"registered\": \"Wednesday, August 26, 2015 9:20 PM\",\n" +
            "    \"latitude\": \"76.541298\",\n" +
            "    \"longitude\": \"-141.658207\",\n" +
            "    \"tags\": [\n" +
            "      \"eu\",\n" +
            "      \"in\",\n" +
            "      \"quis\",\n" +
            "      \"aute\",\n" +
            "      \"aliquip\"\n" +
            "    ],\n" +
            "    \"range\": [\n" +
            "      0,\n" +
            "      1,\n" +
            "      2,\n" +
            "      3,\n" +
            "      4,\n" +
            "      5,\n" +
            "      6,\n" +
            "      7,\n" +
            "      8,\n" +
            "      9\n" +
            "    ],\n" +
            "    \"friends\": [\n" +
            "      {\n" +
            "        \"id\": 0,\n" +
            "        \"name\": \"Donovan Alford\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"Lynch Nunez\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"name\": \"Ada Freeman\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"greeting\": \"Hello, Trina! You have 10 unread messages.\",\n" +
            "    \"favoriteFruit\": \"apple\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"_id\": \"5b0b7273a3afd99a2c01aaa5\",\n" +
            "    \"index\": 2,\n" +
            "    \"guid\": \"b628844f-23d8-4d82-bb92-b9285efe1776\",\n" +
            "    \"isActive\": true,\n" +
            "    \"balance\": \"$1,826.34\",\n" +
            "    \"picture\": \"http://placehold.it/32x32\",\n" +
            "    \"age\": 20,\n" +
            "    \"eyeColor\": \"green\",\n" +
            "    \"name\": {\n" +
            "      \"first\": \"Woodward\",\n" +
            "      \"last\": \"Pacheco\"\n" +
            "    },\n" +
            "    \"company\": \"DAISU\",\n" +
            "    \"email\": \"woodward.pacheco@daisu.com\",\n" +
            "    \"phone\": \"+1 (881) 565-2225\",\n" +
            "    \"address\": \"540 Guider Avenue, Woodlands, Kentucky, 2336\",\n" +
            "    \"about\": \"Ex enim non dolor veniam mollit consequat ullamco est laboris. Ad duis ut aute et laboris exercitation veniam proident voluptate ipsum et anim est. Incididunt occaecat eu irure eu minim adipisicing. Labore magna ipsum laboris veniam cupidatat fugiat ea sint ex reprehenderit.\",\n" +
            "    \"registered\": \"Sunday, October 11, 2015 6:47 AM\",\n" +
            "    \"latitude\": \"71.463031\",\n" +
            "    \"longitude\": \"154.562464\",\n" +
            "    \"tags\": [\n" +
            "      \"velit\",\n" +
            "      \"fugiat\",\n" +
            "      \"nulla\",\n" +
            "      \"velit\",\n" +
            "      \"ut\"\n" +
            "    ],\n" +
            "    \"range\": [\n" +
            "      0,\n" +
            "      1,\n" +
            "      2,\n" +
            "      3,\n" +
            "      4,\n" +
            "      5,\n" +
            "      6,\n" +
            "      7,\n" +
            "      8,\n" +
            "      9\n" +
            "    ],\n" +
            "    \"friends\": [\n" +
            "      {\n" +
            "        \"id\": 0,\n" +
            "        \"name\": \"Monroe Mcintyre\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"Marie Herring\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"name\": \"Juarez Mueller\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"greeting\": \"Hello, Woodward! You have 5 unread messages.\",\n" +
            "    \"favoriteFruit\": \"apple\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"_id\": \"5b0b72737df681eddf3556d7\",\n" +
            "    \"index\": 3,\n" +
            "    \"guid\": \"3cd1ac7c-58da-4fef-8fef-f5bdff30c101\",\n" +
            "    \"isActive\": true,\n" +
            "    \"balance\": \"$1,818.38\",\n" +
            "    \"picture\": \"http://placehold.it/32x32\",\n" +
            "    \"age\": 28,\n" +
            "    \"eyeColor\": \"brown\",\n" +
            "    \"name\": {\n" +
            "      \"first\": \"Hinton\",\n" +
            "      \"last\": \"Flores\"\n" +
            "    },\n" +
            "    \"company\": \"BARKARAMA\",\n" +
            "    \"email\": \"hinton.flores@barkarama.tv\",\n" +
            "    \"phone\": \"+1 (875) 402-3857\",\n" +
            "    \"address\": \"648 Varick Avenue, Edgar, Maine, 5282\",\n" +
            "    \"about\": \"Qui et deserunt aliquip qui incididunt excepteur. Consequat reprehenderit commodo et sit cillum commodo et et consequat laborum fugiat commodo consectetur. Duis adipisicing est Lorem proident fugiat cillum non. Pariatur veniam laboris occaecat eiusmod excepteur sunt ea voluptate do laborum duis sunt consequat. Pariatur ipsum in eiusmod dolor eu cillum incididunt est ea amet pariatur commodo.\",\n" +
            "    \"registered\": \"Sunday, November 29, 2015 3:43 PM\",\n" +
            "    \"latitude\": \"-36.749655\",\n" +
            "    \"longitude\": \"39.416595\",\n" +
            "    \"tags\": [\n" +
            "      \"aliqua\",\n" +
            "      \"est\",\n" +
            "      \"consequat\",\n" +
            "      \"irure\",\n" +
            "      \"consequat\"\n" +
            "    ],\n" +
            "    \"range\": [\n" +
            "      0,\n" +
            "      1,\n" +
            "      2,\n" +
            "      3,\n" +
            "      4,\n" +
            "      5,\n" +
            "      6,\n" +
            "      7,\n" +
            "      8,\n" +
            "      9\n" +
            "    ],\n" +
            "    \"friends\": [\n" +
            "      {\n" +
            "        \"id\": 0,\n" +
            "        \"name\": \"Nellie Brock\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"Jennings Wooten\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"name\": \"Cristina Ramirez\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"greeting\": \"Hello, Hinton! You have 10 unread messages.\",\n" +
            "    \"favoriteFruit\": \"banana\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"_id\": \"5b0b72732f66dd8efa6ba4c5\",\n" +
            "    \"index\": 4,\n" +
            "    \"guid\": \"b6d2127e-d1ca-46aa-8d6d-d24c99a84b3b\",\n" +
            "    \"isActive\": true,\n" +
            "    \"balance\": \"$3,995.09\",\n" +
            "    \"picture\": \"http://placehold.it/32x32\",\n" +
            "    \"age\": 31,\n" +
            "    \"eyeColor\": \"brown\",\n" +
            "    \"name\": {\n" +
            "      \"first\": \"Cole\",\n" +
            "      \"last\": \"Whitfield\"\n" +
            "    },\n" +
            "    \"company\": \"VALPREAL\",\n" +
            "    \"email\": \"cole.whitfield@valpreal.info\",\n" +
            "    \"phone\": \"+1 (838) 480-3794\",\n" +
            "    \"address\": \"429 Rose Street, Bluetown, Montana, 2078\",\n" +
            "    \"about\": \"Eu et ipsum ipsum dolore in fugiat aute mollit eu velit minim do. Cupidatat do commodo nostrud tempor id aliqua in veniam et. Exercitation aute veniam cillum proident non enim cupidatat ea duis minim.\",\n" +
            "    \"registered\": \"Friday, October 23, 2015 3:04 PM\",\n" +
            "    \"latitude\": \"44.796052\",\n" +
            "    \"longitude\": \"-63.507156\",\n" +
            "    \"tags\": [\n" +
            "      \"duis\",\n" +
            "      \"cillum\",\n" +
            "      \"duis\",\n" +
            "      \"officia\",\n" +
            "      \"elit\"\n" +
            "    ],\n" +
            "    \"range\": [\n" +
            "      0,\n" +
            "      1,\n" +
            "      2,\n" +
            "      3,\n" +
            "      4,\n" +
            "      5,\n" +
            "      6,\n" +
            "      7,\n" +
            "      8,\n" +
            "      9\n" +
            "    ],\n" +
            "    \"friends\": [\n" +
            "      {\n" +
            "        \"id\": 0,\n" +
            "        \"name\": \"Campbell Castillo\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"Martinez Bentley\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"name\": \"Melba Walters\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"greeting\": \"Hello, Cole! You have 7 unread messages.\",\n" +
            "    \"favoriteFruit\": \"strawberry\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"_id\": \"5b0b7273530497105f57069b\",\n" +
            "    \"index\": 5,\n" +
            "    \"guid\": \"f7b64d93-cbbf-405a-97b1-5e2bfd6e2665\",\n" +
            "    \"isActive\": true,\n" +
            "    \"balance\": \"$3,919.85\",\n" +
            "    \"picture\": \"http://placehold.it/32x32\",\n" +
            "    \"age\": 40,\n" +
            "    \"eyeColor\": \"blue\",\n" +
            "    \"name\": {\n" +
            "      \"first\": \"Ramona\",\n" +
            "      \"last\": \"Dawson\"\n" +
            "    },\n" +
            "    \"company\": \"RUBADUB\",\n" +
            "    \"email\": \"ramona.dawson@rubadub.org\",\n" +
            "    \"phone\": \"+1 (850) 480-3085\",\n" +
            "    \"address\": \"353 Joval Court, Nord, New Hampshire, 6115\",\n" +
            "    \"about\": \"Ad magna consequat dolor dolore amet esse non eu quis officia. Laborum reprehenderit ullamco officia veniam ea incididunt esse cillum elit occaecat qui reprehenderit id et. Aliqua incididunt exercitation esse consectetur qui id ex et culpa.\",\n" +
            "    \"registered\": \"Wednesday, April 19, 2017 11:38 AM\",\n" +
            "    \"latitude\": \"34.270206\",\n" +
            "    \"longitude\": \"-38.756131\",\n" +
            "    \"tags\": [\n" +
            "      \"cupidatat\",\n" +
            "      \"labore\",\n" +
            "      \"dolore\",\n" +
            "      \"mollit\",\n" +
            "      \"in\"\n" +
            "    ],\n" +
            "    \"range\": [\n" +
            "      0,\n" +
            "      1,\n" +
            "      2,\n" +
            "      3,\n" +
            "      4,\n" +
            "      5,\n" +
            "      6,\n" +
            "      7,\n" +
            "      8,\n" +
            "      9\n" +
            "    ],\n" +
            "    \"friends\": [\n" +
            "      {\n" +
            "        \"id\": 0,\n" +
            "        \"name\": \"Brennan Singleton\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"Kristi Brooks\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"name\": \"Reid Robinson\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"greeting\": \"Hello, Ramona! You have 8 unread messages.\",\n" +
            "    \"favoriteFruit\": \"banana\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"_id\": \"5b0b7273d7433ce8481df352\",\n" +
            "    \"index\": 6,\n" +
            "    \"guid\": \"6d4a9d91-f926-4c14-9a2b-433ea0d431f9\",\n" +
            "    \"isActive\": false,\n" +
            "    \"balance\": \"$3,000.12\",\n" +
            "    \"picture\": \"http://placehold.it/32x32\",\n" +
            "    \"age\": 27,\n" +
            "    \"eyeColor\": \"green\",\n" +
            "    \"name\": {\n" +
            "      \"first\": \"Weber\",\n" +
            "      \"last\": \"Terrell\"\n" +
            "    },\n" +
            "    \"company\": \"COMTOURS\",\n" +
            "    \"email\": \"weber.terrell@comtours.me\",\n" +
            "    \"phone\": \"+1 (942) 441-2368\",\n" +
            "    \"address\": \"737 Portland Avenue, Lumberton, Pennsylvania, 877\",\n" +
            "    \"about\": \"Sunt consectetur elit mollit tempor cillum velit deserunt do. In reprehenderit esse dolor aliqua ex aliquip anim. Ut laboris qui pariatur ea duis occaecat mollit. Nostrud ut sunt sint mollit enim est consectetur.\",\n" +
            "    \"registered\": \"Friday, August 25, 2017 1:50 PM\",\n" +
            "    \"latitude\": \"65.437397\",\n" +
            "    \"longitude\": \"20.730173\",\n" +
            "    \"tags\": [\n" +
            "      \"eu\",\n" +
            "      \"consequat\",\n" +
            "      \"aliqua\",\n" +
            "      \"exercitation\",\n" +
            "      \"irure\"\n" +
            "    ],\n" +
            "    \"range\": [\n" +
            "      0,\n" +
            "      1,\n" +
            "      2,\n" +
            "      3,\n" +
            "      4,\n" +
            "      5,\n" +
            "      6,\n" +
            "      7,\n" +
            "      8,\n" +
            "      9\n" +
            "    ],\n" +
            "    \"friends\": [\n" +
            "      {\n" +
            "        \"id\": 0,\n" +
            "        \"name\": \"Kathie Hinton\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"Morris Burris\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"name\": \"Hodge Steele\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"greeting\": \"Hello, Weber! You have 8 unread messages.\",\n" +
            "    \"favoriteFruit\": \"strawberry\"\n" +
            "  }\n" +
            "]";
}
